package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    private LocalDate datanasc;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDatanasc() { return datanasc; }
    public void setDatanasc(LocalDate datanasc) { this.datanasc = datanasc; }
}
