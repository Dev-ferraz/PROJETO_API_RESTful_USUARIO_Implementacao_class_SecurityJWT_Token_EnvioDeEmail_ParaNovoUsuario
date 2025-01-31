package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioController;

import java.util.List;

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

import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity.UsuarioEntity;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping(value = "/usuario")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

   
  @GetMapping
public ResponseEntity<List<UsuarioEntity>> listarUsuarios() {
    List<UsuarioEntity> usuarios = usuarioService.listaTodos();
    return new ResponseEntity<>(usuarios, HttpStatus.OK);
}

    
    @PostMapping
    public ResponseEntity<UsuarioEntity> cadastrarUsuario(@RequestBody UsuarioEntity usuario) {
        UsuarioEntity novoUsuario = usuarioService.inserir(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntity> alterarUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        try {
            UsuarioEntity usuarioAtualizado = usuarioService.alterar(id, usuario);
            return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
