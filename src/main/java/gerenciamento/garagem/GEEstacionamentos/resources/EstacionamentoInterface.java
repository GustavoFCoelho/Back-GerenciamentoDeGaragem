package gerenciamento.garagem.GEEstacionamentos.resources;

import gerenciamento.garagem.GEEstacionamentos.models.domain.EnderecoEstacionamento;
import gerenciamento.garagem.GEEstacionamentos.models.domain.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionamentoInterface extends JpaRepository<Estacionamento,Integer> {
    Estacionamento findByEndereco(EnderecoEstacionamento enderecoEstacionamento);

    boolean existsByEndereco(EnderecoEstacionamento endereco);
}
