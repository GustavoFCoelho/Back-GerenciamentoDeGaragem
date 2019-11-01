package gerenciamento.garagem.GEEstacionamentos.configs.enviroments;

import gerenciamento.garagem.GEEstacionamentos.services.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBservice dBservice;

    @Bean
    public boolean initalizeDB() throws ParseException{
        dBservice.createData();
        return true;
    }
}
