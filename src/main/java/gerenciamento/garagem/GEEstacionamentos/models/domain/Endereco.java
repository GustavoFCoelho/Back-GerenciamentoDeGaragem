package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rua;
    private String num;
    private String locagradouro;
    @ManyToOne
    private Cidade cidade;

    public Endereco() {
    }

    public Endereco(String rua, String num, String locagradouro) {
        this.rua = rua;
        this.num = num;
        this.locagradouro = locagradouro;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    public String getNum() { return num; }
    public void setNum(String num) { this.num = num; }
    public String getLocagradouro() { return locagradouro; }
    public void setLocagradouro(String locagradouro) { this.locagradouro = locagradouro; }
    public Cidade getCidade() { return cidade; }
    public void setCidade(Cidade cidade) { this.cidade = cidade; }
}
