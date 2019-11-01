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
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Estacionamento getEstacionamento() { return estacionamento; }
    public void setEstacionamento(Estacionamento estacionamento) { this.estacionamento = estacionamento; }
}
