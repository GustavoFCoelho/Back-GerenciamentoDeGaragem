package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Autoridade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToMany
    private List<Funcionario> funcionarios;
    @ManyToMany
    private List<Funcao> funcaos;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Funcionario> getFuncionarios() { return funcionarios; }
    public void setFuncionarios(List<Funcionario> funcionarios) { this.funcionarios = funcionarios; }
    public List<Funcao> getFuncaos() { return funcaos; }
    public void setFuncaos(List<Funcao> funcaos) { this.funcaos = funcaos; }
}
