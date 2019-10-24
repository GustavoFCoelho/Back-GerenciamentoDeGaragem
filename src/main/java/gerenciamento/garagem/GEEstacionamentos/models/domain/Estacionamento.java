package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "estacionamento")
    private List<Vaga> vagas;
    @OneToOne
    private Endereco endereco;
    @OneToMany(mappedBy = "estacionamento")
    private List<Regra> regras;
}
