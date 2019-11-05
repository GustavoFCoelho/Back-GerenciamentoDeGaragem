package gerenciamento.garagem.GEEstacionamentos.services;

import gerenciamento.garagem.GEEstacionamentos.models.domain.*;
import gerenciamento.garagem.GEEstacionamentos.models.dto.CriaClienteDTO;
import gerenciamento.garagem.GEEstacionamentos.models.dto.CriaEstacionamentoDTO;
import gerenciamento.garagem.GEEstacionamentos.resources.CarroInterface;
import gerenciamento.garagem.GEEstacionamentos.resources.ClienteInterface;
import gerenciamento.garagem.GEEstacionamentos.resources.EnderecoClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private CarroInterface carroInterface;
    @Autowired
    private ClienteInterface clienteInterface;
    @Autowired
    private EstacionamentoService estacionamentoService;
    @Autowired
    private EnderecoClienteInterface enderecoClienteInterface;

    public boolean salvar(CriaClienteDTO dto){
        Estado estado = estacionamentoService.dtoToModelEstado(new CriaEstacionamentoDTO(dto));
        if (estado.getId() == 0) {
            estado = estacionamentoService.saveEstado(estado);
        }
        Cidade cidade = estacionamentoService.dtoToModelCidade(new CriaEstacionamentoDTO(dto));
        if (cidade.getId() == 0) {
            cidade.setEstado(estado);
            cidade = estacionamentoService.saveCidade(cidade);
        }
        Cliente cliente = dtoToModelCliente(dto);
        if(clienteInterface.existsByCpf(saveCliente(cliente))){
            EnderecoCliente endereco = dtoToModelEndereco(dto, cidade);
            if (endereco.getId() == 0) {
                endereco.setCliente(cliente);
                if(enderecoClienteInterface.existsById(endereco.getId())){
                    saveEndereco(endereco);
                }
            }
            return true;
        }
        else return false;
    }

    private void saveEndereco(EnderecoCliente endereco) {
        enderecoClienteInterface.save(endereco);
    }

    private EnderecoCliente dtoToModelEndereco(CriaClienteDTO dto, Cidade cidade) {
        if(enderecoClienteInterface.existsByRuaAndNumAndLogradouroAndCidade(dto.getEnderecoRua(), dto.getEnderecoNum(),
                                dto.getEnderecoLogradouro(), cidade)){
            return enderecoClienteInterface.findByRuaAndNumAndLogradouroAndCidade(dto.getEnderecoRua(), dto.getEnderecoNum(),
                    dto.getEnderecoLogradouro(), cidade);
        }
        EnderecoCliente enderecoCliente = new EnderecoCliente();
        enderecoCliente.setCidade(cidade);
        enderecoCliente.setNum(dto.getEnderecoNum());
        enderecoCliente.setRua(dto.getEnderecoRua());
        enderecoCliente.setLogradouro(dto.getEnderecoLogradouro());
        return enderecoCliente;
    }

    private String saveCliente(Cliente cliente) {
        clienteInterface.save(cliente);
        return cliente.getCpf();
    }

    private Cliente dtoToModelCliente(CriaClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getClienteNome());
        cliente.setDatanasc(dto.getDtnasc());
        cliente.setCpf(dto.getCPF());
        cliente.setTipocliente(dto.getTipoCliente());
        return cliente;
    }
}
