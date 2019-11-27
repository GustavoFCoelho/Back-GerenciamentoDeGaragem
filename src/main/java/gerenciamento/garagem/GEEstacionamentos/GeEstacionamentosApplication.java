package gerenciamento.garagem.GEEstacionamentos;

import gerenciamento.garagem.GEEstacionamentos.models.domain.Autoridade;
import gerenciamento.garagem.GEEstacionamentos.resources.AutoridadeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeEstacionamentosApplication implements CommandLineRunner {

	@Autowired
	private AutoridadeInterface anInterface;
	public static void main(String[] args) {
		SpringApplication.run(gerenciamento.garagem.GEEstacionamentos.GeEstacionamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Autoridade autoridade = new Autoridade();
		autoridade.setNome("Admin");
		anInterface.save(autoridade);
		autoridade.setNome("Funcionario");
		anInterface.save(autoridade);

	}
}
