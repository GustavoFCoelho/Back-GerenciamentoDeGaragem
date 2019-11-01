package gerenciamento.garagem.GEEstacionamentos.models.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class EnderecoCliente extends Endereco {
    @ManyToOne
    private Cliente cliente;

    public EnderecoCliente() {
    }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}
