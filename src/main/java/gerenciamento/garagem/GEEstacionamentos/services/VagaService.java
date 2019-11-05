package gerenciamento.garagem.GEEstacionamentos.services;

import gerenciamento.garagem.GEEstacionamentos.models.domain.*;
import gerenciamento.garagem.GEEstacionamentos.models.dto.OcupaVagaDTO;
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
    public boolean ocupaVaga(OcupaVagaDTO ocupaVagaDTO){
        Optional<EnderecoEstacionamento> optE = endEstInterface.findById(ocupaVagaDTO.getIdEnderecoEstacionamento());
        if(optE.isPresent()) {
            Estacionamento estacionamento = estInterface.findByEndereco(optE.get());
            Optional<Vaga> optionalVaga = vgInterface.findByEstacionamentoAndCodigo(estacionamento, ocupaVagaDTO.getCodigoVaga());

            if(optionalVaga.isPresent()) {
                Vaga vaga = optionalVaga.get();

                if(!vaga.isStatus()) {
                    Optional<Carro> optC = crInterface.findByChassi(ocupaVagaDTO.getChassiCarro());

                    if (optC.isPresent()) {
                        Optional<Cliente> optionalCliente = clienteInterface.findByCpf(ocupaVagaDTO.getCpfCliente());

                        if(optionalCliente.isPresent()) {
                            Cliente cliente = optionalCliente.get();
                            cliente.setHoraentrada(ocupaVagaDTO.getHoraEntrada());
                            vaga.setCarro(optC.get());
                            vaga.setStatus(true);
                            return true;
                        } else
                            throw new IllegalArgumentException("Cliente não encontrado!");
                    } else
                        throw new IllegalArgumentException("Carro não encontrado!");
                } else
                    return false;
            } else
                throw new IllegalArgumentException("O Código da vaga não foi encontrado");
        } else
            throw new IllegalArgumentException("Garagem não encontrada!");
    }

    public List<Vaga> findAllByEstacionamento(int id){
        return vgInterface.findAllByEstacionamento(estInterface.findById(id).get());
    }
}
