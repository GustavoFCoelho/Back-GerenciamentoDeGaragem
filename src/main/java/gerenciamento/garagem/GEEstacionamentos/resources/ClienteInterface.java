package gerenciamento.garagem.GEEstacionamentos.resources;

import gerenciamento.garagem.GEEstacionamentos.models.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteInterface extends JpaRepository<Cliente,Integer> {

    boolean existsByCpf(String cpf);

    Optional<Cliente> findByCpf(String cpfCliente);
}
