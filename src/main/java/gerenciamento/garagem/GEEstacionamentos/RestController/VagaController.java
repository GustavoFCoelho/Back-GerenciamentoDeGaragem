package gerenciamento.garagem.GEEstacionamentos.RestController;

import gerenciamento.garagem.GEEstacionamentos.models.dto.OcupaVagaDTO;
import gerenciamento.garagem.GEEstacionamentos.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/vaga")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @PostMapping("/ocuparVaga")
    public ResponseEntity<?> ocuparVaga(@RequestBody OcupaVagaDTO ocvDTO){
        try {
            return ResponseEntity.ok().body(vagaService.ocupaVaga(ocvDTO));
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/vagasPorEstacionamento")
    public ResponseEntity<?> retornaVagasdoEstacionamento(@RequestParam int id){
        return ResponseEntity.ok().body(vagaService.findAllByEstacionamento(id));
    }


}
