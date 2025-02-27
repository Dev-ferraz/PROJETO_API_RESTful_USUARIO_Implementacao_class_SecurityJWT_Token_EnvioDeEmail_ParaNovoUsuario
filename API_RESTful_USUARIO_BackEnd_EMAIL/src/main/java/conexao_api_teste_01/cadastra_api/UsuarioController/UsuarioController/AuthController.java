package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import conexao_api_teste_01.cadastra_api.UsuarioController.DTO.AuthenticationDTO;
import conexao_api_teste_01.cadastra_api.UsuarioController.DTO.UsuarioDTO;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService.AuthService;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDto){
		return ResponseEntity.ok(authService.login(authDto));
	}

	@PostMapping(value = "/novoUsuario")
	public void inserirNovoUsuario(@RequestBody UsuarioDTO novoUsuario){
		usuarioService.inserirNovoUsuario(novoUsuario);
	}
	
	
}