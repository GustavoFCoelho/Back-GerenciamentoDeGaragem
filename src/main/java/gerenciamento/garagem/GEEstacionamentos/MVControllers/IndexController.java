package gerenciamento.garagem.GEEstacionamentos.MVControllers;

import gerenciamento.garagem.GEEstacionamentos.services.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private DBservice dBservice;

    @GetMapping
    public void mapping() throws ParseException {
        dBservice.createData();
    }
}
