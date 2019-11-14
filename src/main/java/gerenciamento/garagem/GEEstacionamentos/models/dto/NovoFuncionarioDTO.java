package gerenciamento.garagem.GEEstacionamentos.models.dto;

import java.time.LocalDate;

public class NovoFuncionarioDTO {
    private String nome;
    private String cpf;
    private LocalDate dtnasc;
    private String email;
    private String senha;
    private String codigoestacionamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(LocalDate dtnasc) {
        this.dtnasc = dtnasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCodigoestacionamento() {
        return codigoestacionamento;
    }

    public void setCodigoestacionamento(String codigoestacionamento) {
        this.codigoestacionamento = codigoestacionamento;
    }
}
