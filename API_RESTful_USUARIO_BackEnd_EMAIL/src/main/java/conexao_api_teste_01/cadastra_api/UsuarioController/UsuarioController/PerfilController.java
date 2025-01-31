package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity.PerfilEntity;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService.PerfilService;

@CrossOrigin
@RestController
@RequestMapping(value = "/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    
    @GetMapping
    public ResponseEntity<List<PerfilEntity>> listarTodosPerfis() {
        List<PerfilEntity> perfis = perfilService.listarTodos();
        return new ResponseEntity<>(perfis, HttpStatus.OK);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<PerfilEntity> buscarPerfilPorId(@PathVariable Long id) {
        Optional<PerfilEntity> perfil = perfilService.buscarPorId(id);
        return perfil.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                     .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    
    @PostMapping
    public ResponseEntity<PerfilEntity> criarPerfil(@RequestBody PerfilEntity perfil) {
        PerfilEntity novoPerfil = perfilService.inserir(perfil);
        return new ResponseEntity<>(novoPerfil, HttpStatus.CREATED);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<PerfilEntity> atualizarPerfil(@PathVariable Long id, @RequestBody PerfilEntity perfilAtualizado) {
        try {
            PerfilEntity perfil = perfilService.atualizar(id, perfilAtualizado);
            return new ResponseEntity<>(perfil, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPerfil(@PathVariable Long id) {
        perfilService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}