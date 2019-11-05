package gerenciamento.garagem.GEEstacionamentos.services;

import gerenciamento.garagem.GEEstacionamentos.models.domain.Cidade;
import gerenciamento.garagem.GEEstacionamentos.models.domain.Cliente;
import gerenciamento.garagem.GEEstacionamentos.models.domain.EnderecoEstacionamento;
import gerenciamento.garagem.GEEstacionamentos.models.domain.Estado;
import gerenciamento.garagem.GEEstacionamentos.models.dto.CriaClienteDTO;
import gerenciamento.garagem.GEEstacionamentos.models.dto.CriaEstacionamentoDTO;
import gerenciamento.garagem.GEEstacionamentos.resources.CarroInterface;
import gerenciamento.garagem.GEEstacionamentos.resources.ClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private CarroInterface carroInterface;
    @Autowired
    private ClienteInterface clienteInterface;
    @Autowired
    private EstacionamentoService estacionamentoService;

    public boolean salvar(CriaClienteDTO dto){
        Estado estado = estacionamentoService.dtoToModelEstado(new CriaEstacionamentoDTO(dto));
        if (estado.getId() == 0) {
            estado = estacionamentoService.saveEstado(estado);
        }
        Cidade cidade = estacionamentoService.dtoToModelCidade(new CriaEstacionamentoDTO(dto));
        if (cidade.getId() == 0) {
            cidade.setEstado(estado);
            cidade = estacionamentoService.saveCidade(cidade);
        }
        EnderecoEstacionamento endereco = estacionamentoService.dtoToModelEndereco(new CriaEstacionamentoDTO(dto), cidade);
        if (endereco.getId() == 0) {
            endereco = estacionamentoService.saveEndereco(endereco);
        }
        Cliente cliente = dtoToModelCliente(dto);
        if(clienteInterface.existsByCpf(saveCliente(cliente))){
            return true;
        }
        else return false;
    }

    private String saveCliente(Cliente cliente) {
        clienteInterface.save(cliente);
        return cliente.getCpf();
    }

    private Cliente dtoToModelCliente(CriaClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getClienteNome());
        cliente.setDatanasc(dto.getDtnasc());
        cliente.setCpf(dto.getCPF());
        cliente.setTipocliente(dto.getTipoCliente());
        return cliente;
    }


}
