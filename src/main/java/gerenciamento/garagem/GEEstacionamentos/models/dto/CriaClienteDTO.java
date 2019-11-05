package gerenciamento.garagem.GEEstacionamentos.models.dto;

import gerenciamento.garagem.GEEstacionamentos.models.enums.TipoCliente;

import java.time.LocalDate;

public class CriaClienteDTO {
    private String clienteNome;
    private String CPF;
    private LocalDate dtnasc;
    private String carroChassi;
    private String placa;
    private String estadoUF;
    private String estadoNome;
    private String cidadeNome;
    private String enderecoRua;
    private String enderecoNum;
    private String enderecoLogradouro;
    private TipoCliente tipoCliente;

    public String getClienteNome() { return clienteNome; }
    public void setClienteNome(String clienteNome) { this.clienteNome = clienteNome; }
    public String getCPF() { return CPF; }
    public void setCPF(String CPF) { this.CPF = CPF; }
    public LocalDate getDtnasc() { return dtnasc; }
    public void setDtnasc(LocalDate dtnasc) { this.dtnasc = dtnasc; }
    public String getCarroChassi() { return carroChassi; }
    public void setCarroChassi(String carroChassi) { this.carroChassi = carroChassi; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getEstadoUF() { return estadoUF; }
    public void setEstadoUF(String estadoUF) { this.estadoUF = estadoUF; }
    public String getEstadoNome() { return estadoNome; }
    public void setEstadoNome(String estadoNome) { this.estadoNome = estadoNome; }
    public String getCidadeNome() { return cidadeNome; }
    public void setCidadeNome(String cidadeNome) { this.cidadeNome = cidadeNome; }
    public String getEnderecoRua() { return enderecoRua; }
    public void setEnderecoRua(String enderecoRua) { this.enderecoRua = enderecoRua; }
    public String getEnderecoNum() { return enderecoNum; }
    public void setEnderecoNum(String enderecoNum) { this.enderecoNum = enderecoNum; }
    public String getEnderecoLogradouro() { return enderecoLogradouro; }
    public void setEnderecoLogradouro(String enderecoLogradouro) { this.enderecoLogradouro = enderecoLogradouro; }
    public TipoCliente getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(TipoCliente tipoCliente) { this.tipoCliente = tipoCliente; }
}
