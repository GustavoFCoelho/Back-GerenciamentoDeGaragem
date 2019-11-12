package gerenciamento.garagem.GEEstacionamentos.RestController;

import gerenciamento.garagem.GEEstacionamentos.models.dto.CarroDTO;
import gerenciamento.garagem.GEEstacionamentos.models.dto.CriaClienteDTO;
import gerenciamento.garagem.GEEstacionamentos.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/cliente")
public class ClienteRestController {
    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<?> index(@RequestBody CriaClienteDTO dto){
        boolean boleano = service.salvar(dto);
        if(boleano){
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }

    @PostMapping("/savecarro")
    public ResponseEntity<?> index(@RequestBody CarroDTO dto){
        boolean boleano = service.salvaCarro(dto);
        if(boleano){
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }
}
