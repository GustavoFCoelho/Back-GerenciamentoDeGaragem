package gerenciamento.garagem.GEEstacionamentos.resources;

import gerenciamento.garagem.GEEstacionamentos.models.domain.Autoridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutoridadeInterface extends JpaRepository<Autoridade, Integer> {
    boolean existsByNome(String nomeAutoridade);

    Optional<Autoridade> findByNome(String nomeAutoridade);
}
