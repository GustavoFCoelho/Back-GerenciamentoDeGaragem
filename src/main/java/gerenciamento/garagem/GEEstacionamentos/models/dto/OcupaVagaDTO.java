package gerenciamento.garagem.GEEstacionamentos.models.dto;

import java.time.LocalDateTime;

public class OcupaVagaDTO {
    private int idEnderecoEstacionamento;
    private String cpfCliente;
    private String codigoVaga;
    private String chassiCarro;
    private LocalDateTime horaEntrada;

    public OcupaVagaDTO() {
    }

    public OcupaVagaDTO(int idEnderecoEstacionamento, String codigoVaga, String chassiCarro, LocalDateTime horaEntrada) {
        this.idEnderecoEstacionamento = idEnderecoEstacionamento;
        this.codigoVaga = codigoVaga;
        this.chassiCarro = chassiCarro;
        this.horaEntrada = horaEntrada;
    }
    public String getCpfCliente() { return cpfCliente; }
    public void setCpfCliente(String cpfCliente) { this.cpfCliente = cpfCliente; }
    public int getIdEnderecoEstacionamento() { return idEnderecoEstacionamento; }
    public void setIdEnderecoEstacionamento(int idEnderecoEstacionamento) { this.idEnderecoEstacionamento = idEnderecoEstacionamento; }
    public String getCodigoVaga() { return codigoVaga; }
    public void setCodigoVaga(String codigoVaga) { this.codigoVaga = codigoVaga; }
    public String getChassiCarro() { return chassiCarro; }
    public void setChassiCarro(String chassiCarro) { this.chassiCarro = chassiCarro; }
    public LocalDateTime getHoraEntrada() { return horaEntrada; }
    public void setHoraEntrada(LocalDateTime horaEntrada) { this.horaEntrada = horaEntrada; }
}
