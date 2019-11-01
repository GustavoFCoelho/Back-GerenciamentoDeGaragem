package gerenciamento.garagem.GEEstacionamentos.models.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class EnderecoEstacionamento extends Endereco {

    @OneToOne(mappedBy = "endereco")
    @JsonIgnore
    private Estacionamento estacionamento;

    public EnderecoEstacionamento() {
    }

    public EnderecoEstacionamento(String rua, String num, String locagradouro) {
        super(rua, num, locagradouro);
    }

    public Estacionamento getEstacionamento() { return estacionamento; }
    public void setEstacionamento(Estacionamento estacionamento) { this.estacionamento = estacionamento; }
}
