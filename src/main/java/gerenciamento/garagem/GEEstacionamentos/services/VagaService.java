package gerenciamento.garagem.GEEstacionamentos.services;

import gerenciamento.garagem.GEEstacionamentos.models.domain.*;
import gerenciamento.garagem.GEEstacionamentos.models.dto.OcupaVagaDTO;
import gerenciamento.garagem.GEEstacionamentos.models.dto.VagaDTO;
import gerenciamento.garagem.GEEstacionamentos.resources.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VagaService {
    @Autowired
    private VagaInterface vgInterface;
    @Autowired
    private CarroInterface crInterface;
    @Autowired
    private EstacionamentoInterface estInterface;
    @Autowired
    private EnderecoEstacionamentoInterface endEstInterface;
    @Autowired
    private ClienteInterface clienteInterface;

    @Transactional
    public boolean ocupaVaga(OcupaVagaDTO ocupaVagaDTO) {

        Optional<EnderecoEstacionamento> optE = endEstInterface.findById(ocupaVagaDTO.getIdEnderecoEstacionamento());
        if (!optE.isPresent()) {
            throw new IllegalArgumentException("Garagem não encontrada!");
        }
        Estacionamento estacionamento = estInterface.findByEndereco(optE.get());
        Optional<Vaga> optionalVaga = vgInterface.findByEstacionamentoAndCodigo(estacionamento, ocupaVagaDTO.getCodigoVaga());

        if(!optionalVaga.isPresent()) {
            throw new IllegalArgumentException("O Código da vaga não foi encontrado");
        }

        Vaga vaga  = optionalVaga.get();
        if(vaga.isStatus()){
            return false;
        }

        Optional<Cliente> optionalCliente = clienteInterface.findByCpf(ocupaVagaDTO.getCpfCliente());
        if(!optionalCliente.isPresent()) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }

        Cliente cliente = optionalCliente.get();
        Optional<Carro> optC = crInterface.findByChassi(ocupaVagaDTO.getChassiCarro());
        if(!optC.isPresent()){
            throw new IllegalArgumentException("Carro não encontrado!");
        }


        cliente.setHoraentrada(ocupaVagaDTO.getHoraEntrada());
        vaga.setCarro(optC.get());
        vaga.setStatus(true);
        return true;
    }

    public List<Vaga> findAllByEstacionamento(int id) {
        return vgInterface.findAllByEstacionamento(estInterface.findById(id).get());
    }

    public boolean criarvaga(VagaDTO dto){
        Vaga vaga = dtoToModelVaga(dto);
        vaga = vgInterface.save(vaga);
        return vgInterface.existsById(vaga.getId());
    }

    private Vaga dtoToModelVaga(VagaDTO dto) {
        Vaga vaga = new Vaga();
        if(estInterface.findByCodigoestacionamento(dto.getCodigoestacionamento()).isPresent()){
            vaga.setEstacionamento(estInterface.findByCodigoestacionamento(dto.getCodigoestacionamento()).get());
            vaga.setCodigo(dto.getCodigovaga());
            return vaga;
        } else {
            throw new IllegalArgumentException("Estacionamento não encontrado!");
        }
    }
}
