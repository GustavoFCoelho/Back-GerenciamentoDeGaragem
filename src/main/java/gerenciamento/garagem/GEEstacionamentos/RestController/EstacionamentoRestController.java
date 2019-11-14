package gerenciamento.garagem.GEEstacionamentos.RestController;

import gerenciamento.garagem.GEEstacionamentos.models.dto.CriaEstacionamentoDTO;
import gerenciamento.garagem.GEEstacionamentos.models.dto.NovoFuncionarioDTO;
import gerenciamento.garagem.GEEstacionamentos.services.EstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/estacionamento")
public class EstacionamentoRestController {
    @Autowired
    private EstacionamentoService estacionamentoService;

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody CriaEstacionamentoDTO estacionamentoDTO){
        try{
            return ResponseEntity.ok().body(estacionamentoService.save(estacionamentoDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addfunc")
    public ResponseEntity<?> savefunc(@RequestBody NovoFuncionarioDTO dto){
        try{
            return ResponseEntity.ok().body(estacionamentoService.cadastraFuncionario(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
