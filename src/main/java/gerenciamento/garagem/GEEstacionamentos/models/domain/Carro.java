package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.*;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String chassi;
    @ManyToOne
    private Cliente dono;
    @OneToOne(mappedBy = "carro")
    private Vaga vaga;
    private String placa;

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
