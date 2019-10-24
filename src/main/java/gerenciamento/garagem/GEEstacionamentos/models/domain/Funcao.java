package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Funcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @ManyToMany
    private List<Autoridade> autoridades;
}
