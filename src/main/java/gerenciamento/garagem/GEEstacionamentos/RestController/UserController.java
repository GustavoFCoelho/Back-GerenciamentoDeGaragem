package gerenciamento.garagem.GEEstacionamentos.RestController;

import gerenciamento.garagem.GEEstacionamentos.models.dto.AutoridadeDTO;
import gerenciamento.garagem.GEEstacionamentos.models.dto.LogarDTO;
import gerenciamento.garagem.GEEstacionamentos.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> login (@RequestBody LogarDTO dtologin){

        if(userService.logar(dtologin)){
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }

    @PostMapping("/autoridade")
    public ResponseEntity<?> login (@RequestBody AutoridadeDTO dtoAutoridade) throws Exception {

        if(userService.novaAutoridade(dtoAutoridade)){
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.badRequest().body(false);
        }
    }
}
