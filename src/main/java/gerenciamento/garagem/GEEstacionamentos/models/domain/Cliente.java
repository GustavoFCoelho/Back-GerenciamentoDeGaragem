package gerenciamento.garagem.GEEstacionamentos.models.domain;

import gerenciamento.garagem.GEEstacionamentos.models.enums.TipoCliente;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Cliente extends Pessoa {
    private TipoCliente tipocliente;
    private LocalDateTime horaentrada;
    private LocalDateTime horasaida;
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;
    @OneToMany(mappedBy = "dono")
    private List<Carro> carros;

    public TipoCliente getTipocliente() { return tipocliente; }
    public void setTipocliente(TipoCliente tipocliente) { this.tipocliente = tipocliente; }
    public LocalDateTime getHoraentrada() { return horaentrada; }
    public void setHoraentrada(LocalDateTime horaentrada) { this.horaentrada = horaentrada; }
    public LocalDateTime getHorasaida() { return horasaida; }
    public void setHorasaida(LocalDateTime horasaida) { this.horasaida = horasaida; }
    public List<Endereco> getEnderecos() { return enderecos; }
    public void setEnderecos(List<Endereco> enderecos) { this.enderecos = enderecos; }
    public List<Carro> getCarros() { return carros; }
    public void setCarros(List<Carro> carros) { this.carros = carros; }
}
