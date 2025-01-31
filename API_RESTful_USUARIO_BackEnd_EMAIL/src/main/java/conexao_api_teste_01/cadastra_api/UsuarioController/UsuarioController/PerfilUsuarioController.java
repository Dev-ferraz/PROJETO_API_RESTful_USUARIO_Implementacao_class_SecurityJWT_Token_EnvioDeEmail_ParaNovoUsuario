package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity.PerfilUsuarioEntity;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService.PerfilUsuarioService;

@CrossOrigin
@RestController
@RequestMapping(value = "/perfilUsuario" )
public class PerfilUsuarioController {
    
    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    
    @GetMapping
    public ResponseEntity<List<PerfilUsuarioEntity>> listarTodosPerfis() {
        List<PerfilUsuarioEntity> perfis = perfilUsuarioService.listarTodos();
        return new ResponseEntity<>(perfis, HttpStatus.OK);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<PerfilUsuarioEntity> buscarPerfilPorId(@PathVariable Long id) {
        Optional<PerfilUsuarioEntity> perfil = perfilUsuarioService.buscarPorId(id);
        return perfil.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    
    @PostMapping
    public ResponseEntity<PerfilUsuarioEntity> criarPerfil(@RequestBody PerfilUsuarioEntity perfilUsuario) {
        PerfilUsuarioEntity novoPerfil = perfilUsuarioService.inserir(perfilUsuario);
        return new ResponseEntity<>(novoPerfil, HttpStatus.CREATED);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<PerfilUsuarioEntity> alterarPerfilUsuario(@PathVariable Long id, @RequestBody PerfilUsuarioEntity perfilAtualizado) {
        try {
            PerfilUsuarioEntity perfil = perfilUsuarioService.alterar(id, perfilAtualizado);
            return new ResponseEntity<>(perfil, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPerfil(@PathVariable Long id) {
        perfilUsuarioService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
}
