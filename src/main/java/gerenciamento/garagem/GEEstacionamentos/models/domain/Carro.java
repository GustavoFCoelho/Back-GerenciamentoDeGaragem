package gerenciamento.garagem.GEEstacionamentos.models.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String chassi;
    @ManyToOne
    private Cliente dono;
    @JsonIgnore
    @OneToOne(mappedBy = "carro")
    private Vaga vaga;
    private String placa;

    public Carro() {
    }

    public Carro(String chassi, Cliente dono, String placa) {
        this.chassi = chassi;
        this.dono = dono;
        this.placa = placa;
    }

    public Carro(String chassi, Cliente dono, Vaga vaga, String placa) {
        this.chassi = chassi;
        this.dono = dono;
        this.vaga = vaga;
        this.placa = placa;
    }

    public Carro(String chassi, String placa) {
        this.chassi = chassi;
        this.placa = placa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getChassi() { return chassi; }
    public void setChassi(String chassi) { this.chassi = chassi; }
    public Cliente getDono() { return dono; }
    public void setDono(Cliente dono) { this.dono = dono; }
    public Vaga getVaga() { return vaga; }
    public void setVaga(Vaga vaga) { this.vaga = vaga; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
}
