package gerenciamento.garagem.GEEstacionamentos.RestController;

import gerenciamento.garagem.GEEstacionamentos.models.dto.OcupaVagaDTO;
import gerenciamento.garagem.GEEstacionamentos.models.dto.VagaDTO;
import gerenciamento.garagem.GEEstacionamentos.services.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/vaga")
public class VagaRestController {
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

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody VagaDTO vagaDTO){
        try {
            return ResponseEntity.ok().body(vagaService.criarvaga(vagaDTO));
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/desocupaVaga")
    public ResponseEntity<?> desocupaVaga(@RequestBody VagaDTO s) throws Exception {
        if(!vagaService.desocupaVaga(s)){
            return ResponseEntity.ok().body(true);
        } else
            return ResponseEntity.badRequest().body(false);
    }

}
