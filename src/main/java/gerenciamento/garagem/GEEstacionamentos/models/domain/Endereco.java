package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rua;
    private String num;
    private String locagradouro;
    @ManyToOne
    private Cidade cidade;
    @ManyToOne
    private Cliente cliente;
    @OneToOne(mappedBy = "endereco")
    private Estacionamento estacionamento;
}
