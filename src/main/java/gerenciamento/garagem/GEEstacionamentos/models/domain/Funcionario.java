package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.*;

@Entity
public class Funcionario extends Pessoa{

    private String email;
    private String carteira;
    private String senha;
    @ManyToOne
    private Autoridade autoridade;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCarteira() { return carteira; }
    public void setCarteira(String carteira) { this.carteira = carteira; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public Autoridade getAutoridade() { return autoridade; }
    public void setAutoridade(Autoridade autoridade) { this.autoridade = autoridade; }
}
