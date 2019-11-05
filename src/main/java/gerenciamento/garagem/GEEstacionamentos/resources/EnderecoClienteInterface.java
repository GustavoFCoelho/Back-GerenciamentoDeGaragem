package gerenciamento.garagem.GEEstacionamentos.resources;

import gerenciamento.garagem.GEEstacionamentos.models.domain.Cidade;
import gerenciamento.garagem.GEEstacionamentos.models.domain.EnderecoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoClienteInterface extends JpaRepository<EnderecoCliente,Integer> {
    boolean existsByRuaAndNumAndLogradouroAndCidade(String enderecoRua, String enderecoNum, String enderecoLogradouro, Cidade cidade);

    EnderecoCliente findByRuaAndNumAndLogradouroAndCidade(String enderecoRua, String enderecoNum, String enderecoLogradouro, Cidade cidade);
}
