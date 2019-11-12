package gerenciamento.garagem.GEEstacionamentos.models.dto;

public class CarroDTO {
    private String cpfDono;
    private String chassi;
    private String placa;

    public String getCpfDono() { return cpfDono; }
    public void setCpfDono(String cpfDono) { this.cpfDono = cpfDono; }
    public String getChassi() { return chassi; }
    public void setChassi(String chassi) { this.chassi = chassi; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
}
