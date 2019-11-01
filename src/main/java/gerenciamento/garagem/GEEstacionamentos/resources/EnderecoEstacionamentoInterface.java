package gerenciamento.garagem.GEEstacionamentos.resources;

import gerenciamento.garagem.GEEstacionamentos.models.domain.Cidade;
import gerenciamento.garagem.GEEstacionamentos.models.domain.EnderecoEstacionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoEstacionamentoInterface extends JpaRepository<EnderecoEstacionamento,Integer> {
    boolean existsByCidade(Cidade cidade);

    EnderecoEstacionamento findByCidade(Cidade cidade);

    boolean existsByRuaAndLogradouroAndNum(String enderecoRua, String enderecoLogradouro, String enderecoNum);

    EnderecoEstacionamento findByRuaAndLogradouroAndNum(String enderecoRua, String enderecoLogradouro, String enderecoNum);

    EnderecoEstacionamento findByRuaAndLogradouroAndNumAndCidade(String enderecoRua, String enderecoLogradouro, String enderecoNum, Cidade cidade);

    boolean existsByRuaAndLogradouroAndNumAndCidade(String enderecoRua, String enderecoLogradouro, String enderecoNum, Cidade cidade);
}
