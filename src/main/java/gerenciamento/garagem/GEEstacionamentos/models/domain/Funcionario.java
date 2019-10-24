package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.*;

@Entity
public class Funcionario extends Pessoa{

    private String email;
    private String carteira;
    private String senha;
    @ManyToOne
    private Autoridade autoridade;
}
