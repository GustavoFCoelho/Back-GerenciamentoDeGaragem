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

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Autoridade> getAutoridades() { return autoridades; }
    public void setAutoridades(List<Autoridade> autoridades) { this.autoridades = autoridades; }
}
