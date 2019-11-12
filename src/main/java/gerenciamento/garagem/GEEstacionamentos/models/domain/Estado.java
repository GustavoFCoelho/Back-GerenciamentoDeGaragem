package gerenciamento.garagem.GEEstacionamentos.models.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String UF;
    private String nome;
    @OneToMany(mappedBy = "estado")
    @JsonIgnore
    private List<Cidade> cidades;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUF() { return UF; }
    public void setUF(String UF) { this.UF = UF; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Cidade> getCidades() { return cidades; }
    public void setCidades(List<Cidade> cidades) { this.cidades = cidades; }
}
