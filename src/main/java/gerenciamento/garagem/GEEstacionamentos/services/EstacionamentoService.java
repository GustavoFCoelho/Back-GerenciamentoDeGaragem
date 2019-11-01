package gerenciamento.garagem.GEEstacionamentos.services;

import gerenciamento.garagem.GEEstacionamentos.models.domain.Cidade;
import gerenciamento.garagem.GEEstacionamentos.models.domain.EnderecoEstacionamento;
import gerenciamento.garagem.GEEstacionamentos.models.domain.Estacionamento;
import gerenciamento.garagem.GEEstacionamentos.models.domain.Estado;
import gerenciamento.garagem.GEEstacionamentos.models.dto.CriaEstacionamentoDTO;
import gerenciamento.garagem.GEEstacionamentos.resources.CidadeInterface;
import gerenciamento.garagem.GEEstacionamentos.resources.EnderecoEstacionamentoInterface;
import gerenciamento.garagem.GEEstacionamentos.resources.EstacionamentoInterface;
import gerenciamento.garagem.GEEstacionamentos.resources.EstadoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstacionamentoService {
    @Autowired
    private EstacionamentoInterface estacionamentoInterface;
    @Autowired
    private CidadeInterface cidadeInterface;
    @Autowired
    private EnderecoEstacionamentoInterface enderecoEstacionamentoInterface;
    @Autowired
    private EstadoInterface estadoInterface;

    public boolean save(CriaEstacionamentoDTO estacionamentoDTO) throws Exception {
        Estado estado = dtoToModelEstado(estacionamentoDTO);
        if(estado.getId() == 0) {
            estado = saveEstado(estado);
        }
        Cidade cidade = dtoToModelCidade(estacionamentoDTO);
        if(cidade.getId() == 0){
            cidade.setEstado(estado);
            cidade = saveCidade(cidade);
        }
        EnderecoEstacionamento endereco = dtoToModelEndereco(estacionamentoDTO, cidade);
        if(endereco.getId() == 0){
            endereco = saveEndereco(endereco);
        }
        if(estacionamentoInterface.existsByEndereco(endereco)){
            throw new Exception("Já existe uma Garagem anexada a este endereço!");
        } else {
            Estacionamento estacionamento = new Estacionamento();
            estacionamento.setEndereco(endereco);
            estacionamentoInterface.save(estacionamento);
            return true;
        }
    }

    private EnderecoEstacionamento saveEndereco(EnderecoEstacionamento endereco) {
        return enderecoEstacionamentoInterface.save(endereco);
    }

    private EnderecoEstacionamento dtoToModelEndereco(CriaEstacionamentoDTO estacionamentoDTO, Cidade cidade) {
        if(enderecoEstacionamentoInterface.existsByRuaAndLogradouroAndNumAndCidade(estacionamentoDTO.getEnderecoRua(),
                estacionamentoDTO.getEnderecoLogradouro(), estacionamentoDTO.getEnderecoNum(), cidade)) {
            return enderecoEstacionamentoInterface.findByRuaAndLogradouroAndNumAndCidade(estacionamentoDTO.getEnderecoRua(),
                    estacionamentoDTO.getEnderecoLogradouro(), estacionamentoDTO.getEnderecoNum(), cidade);
        } else {
            EnderecoEstacionamento estacionamento = new EnderecoEstacionamento();
            estacionamento.setRua(estacionamentoDTO.getEnderecoRua());
            estacionamento.setNum(estacionamentoDTO.getEnderecoNum());
            estacionamento.setLogradouro(estacionamentoDTO.getEnderecoLogradouro());
            estacionamento.setCidade(cidade);
            return estacionamento;
        }
    }

    private Cidade saveCidade(Cidade cidade) {
        return cidadeInterface.save(cidade);
    }

    private Cidade dtoToModelCidade(CriaEstacionamentoDTO estacionamentoDTO) {
        if(cidadeInterface.existsByNomeAndEstado(estacionamentoDTO.getCidadeNome(), estadoInterface.findByNome(estacionamentoDTO.getEstadoNome()))){
            return cidadeInterface.findByNomeAndEstado(estacionamentoDTO.getCidadeNome(), estadoInterface.findByNome(estacionamentoDTO.getEstadoNome()));
        } else {
            Cidade cidade = new Cidade();
            cidade.setNome(estacionamentoDTO.getCidadeNome());
            return cidade;
        }
    }

    private Estado saveEstado(Estado estado) {
        return estadoInterface.save(estado);
    }

    private Estado dtoToModelEstado(CriaEstacionamentoDTO estacionamentoDTO) {
        if(estadoInterface.existsByNome(estacionamentoDTO.getEstadoNome())){
            return estadoInterface.findByNome(estacionamentoDTO.getEstadoNome());
        } else{
            Estado estado = new Estado();
            estado.setNome(estacionamentoDTO.getEstadoNome());
            estado.setUF(estacionamentoDTO.getEstadoUF());
            return estado;
        }
    }
}
