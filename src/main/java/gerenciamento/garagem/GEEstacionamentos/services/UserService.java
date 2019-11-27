package gerenciamento.garagem.GEEstacionamentos.services;

import gerenciamento.garagem.GEEstacionamentos.models.domain.Autoridade;
import gerenciamento.garagem.GEEstacionamentos.models.domain.Funcionario;
import gerenciamento.garagem.GEEstacionamentos.models.dto.AutoridadeDTO;
import gerenciamento.garagem.GEEstacionamentos.models.dto.LogarDTO;
import gerenciamento.garagem.GEEstacionamentos.resources.AutoridadeInterface;
import gerenciamento.garagem.GEEstacionamentos.resources.FuncionarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private AutoridadeInterface autoridadeInterface;
    @Autowired
    private FuncionarioInterface funcionarioInterface;

    public boolean logar(LogarDTO dto){
        Optional<Funcionario> optfuncionario = funcionarioInterface.findByCpf(dto.getCpf());
        if(!optfuncionario.isPresent()){
            return false;
        }

        Funcionario funcionario = optfuncionario.get();
        if(funcionario.getSenha().equals(dto.getSenha())){
            return true;
        }

        return false;

    }

    public boolean novaAutoridade (AutoridadeDTO dto) throws Exception {
        Autoridade autoridade = dtoToModelAutoridade(dto);
        autoridade =  autoridadeInterface.save(autoridade);
        return autoridadeInterface.existsById(autoridade.getId());
    }

    private Autoridade dtoToModelAutoridade(AutoridadeDTO dto) throws Exception {

        if(autoridadeInterface.existsByNome(dto.getNomeAutoridade())){
            throw new Exception("Autoridade já existe");
        }
        Autoridade autoridade = new Autoridade();
        autoridade.setNome(dto.getNomeAutoridade());
        return autoridade;
    }

    @Transactional
    public void setaAutoridade(AutoridadeDTO dto){
        Optional<Funcionario> func = funcionarioInterface.findByCpf(dto.getCpf());
        if(!func.isPresent()){
            throw new IllegalArgumentException("Funcionario não encontrado");
        }

        Optional<Autoridade> auth = autoridadeInterface.findByNome(dto.getNomeAutoridade());
        if(!auth.isPresent()){
            throw new IllegalArgumentException("Autoridade não encontrada");
        }

        func.get().setAutoridade(auth.get());
    }
}
