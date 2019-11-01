package gerenciamento.garagem.GEEstacionamentos.services;

import gerenciamento.garagem.GEEstacionamentos.models.domain.Carro;
import gerenciamento.garagem.GEEstacionamentos.models.domain.EnderecoEstacionamento;
import gerenciamento.garagem.GEEstacionamentos.models.domain.Estacionamento;
import gerenciamento.garagem.GEEstacionamentos.models.domain.Vaga;
import gerenciamento.garagem.GEEstacionamentos.resources.CarroInterface;
import gerenciamento.garagem.GEEstacionamentos.resources.EnderecoEstacionamentoInterface;
import gerenciamento.garagem.GEEstacionamentos.resources.EstacionamentoInterface;
import gerenciamento.garagem.GEEstacionamentos.resources.VagaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBservice {

    @Autowired
    private VagaInterface vagaInterface;
    @Autowired
    private EnderecoEstacionamentoInterface enderecoEstacionamentoInterface;
    @Autowired
    private CarroInterface carroInterface;
    @Autowired
    private EstacionamentoInterface estacionamentoInterface;


    public void createData() throws ParseException {
        EnderecoEstacionamento enderecoEstacionamento = new EnderecoEstacionamento("Rua Condor", "2523", "Terras Verdes");
        enderecoEstacionamentoInterface.save(enderecoEstacionamento);
        Estacionamento estacionamento = new Estacionamento(enderecoEstacionamento);
        estacionamentoInterface.save(estacionamento);
        List<Vaga> vaga = new ArrayList<>();
        vaga.add(new Vaga("EU8", estacionamento));
        vaga.add(new Vaga("UWI4", estacionamento));
        vaga.add(new Vaga("ED6", estacionamento));
        vaga.add(new Vaga("E3", estacionamento));
        vaga.add(new Vaga("ET2", estacionamento));
        vagaInterface.saveAll(vaga);
        Carro carro = new Carro("15158", "EU7E458");
        carroInterface.save(carro);
    }
}
