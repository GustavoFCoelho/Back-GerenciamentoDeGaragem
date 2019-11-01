package gerenciamento.garagem.GEEstacionamentos.resources;

import gerenciamento.garagem.GEEstacionamentos.models.domain.Estacionamento;
import gerenciamento.garagem.GEEstacionamentos.models.domain.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VagaInterface extends JpaRepository<Vaga,Integer> {
    Optional<Vaga> findByEstacionamentoAndCodigo(Estacionamento estacionamento, String codigoVaga);

    List<Vaga> findAllByEstacionamento(Estacionamento estacionamento);
}
