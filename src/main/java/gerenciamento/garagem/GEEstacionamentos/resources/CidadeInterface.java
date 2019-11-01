package gerenciamento.garagem.GEEstacionamentos.resources;

import gerenciamento.garagem.GEEstacionamentos.models.domain.Cidade;
import gerenciamento.garagem.GEEstacionamentos.models.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeInterface extends JpaRepository<Cidade,Integer> {
    boolean existsByNomeAndEstado(String cidadeNome, Estado byNome);

    Cidade findByNomeAndEstado(String cidadeNome, Estado byNome);
}
