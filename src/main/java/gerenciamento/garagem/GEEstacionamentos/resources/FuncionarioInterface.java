package gerenciamento.garagem.GEEstacionamentos.resources;

import gerenciamento.garagem.GEEstacionamentos.models.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioInterface extends JpaRepository<Funcionario,Integer> {
    boolean existsByCpf(String cpf);

    Optional<Funcionario> findByCpf(String cpf);
}
