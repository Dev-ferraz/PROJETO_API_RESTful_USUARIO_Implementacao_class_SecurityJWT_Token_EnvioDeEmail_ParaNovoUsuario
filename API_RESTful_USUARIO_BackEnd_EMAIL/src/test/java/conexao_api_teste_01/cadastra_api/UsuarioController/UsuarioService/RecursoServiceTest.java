package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService;

import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioRepository.RecursoRepository;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RecursoServiceTest {
	@Test
	public void RecursoService() {
		RecursoRepository recursoRepository = null;
		RecursoService expected = new RecursoService(null);
		RecursoService actual = new RecursoService(recursoRepository);

		assertEquals(expected, actual);
	}
}
