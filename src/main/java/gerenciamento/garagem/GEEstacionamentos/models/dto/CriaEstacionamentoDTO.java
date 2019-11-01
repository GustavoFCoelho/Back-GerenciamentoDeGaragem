package gerenciamento.garagem.GEEstacionamentos.models.dto;

public class CriaEstacionamentoDTO {
    private String estadoUF;
    private String estadoNome;
    private String cidadeNome;
    private String enderecoRua;
    private String enderecoNum;
    private String enderecoLogradouro;

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
}
