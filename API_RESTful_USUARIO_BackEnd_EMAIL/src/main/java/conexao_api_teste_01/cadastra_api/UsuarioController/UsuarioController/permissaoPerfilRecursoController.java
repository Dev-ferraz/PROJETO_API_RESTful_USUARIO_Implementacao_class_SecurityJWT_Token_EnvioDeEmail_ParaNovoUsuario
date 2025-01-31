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

import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity.PermissaoPerfilRecursoEntity;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService.PermissaoPerfilRecursoService;



@CrossOrigin
@RestController
@RequestMapping(value = "/permissaoPerfilRecurso")
public class permissaoPerfilRecursoController {

    @Autowired
    private PermissaoPerfilRecursoService permissaoPerfilRecursoService;

    @GetMapping
    public ResponseEntity<List<PermissaoPerfilRecursoEntity>> listarRecursos() {
        List<PermissaoPerfilRecursoEntity> recursos = permissaoPerfilRecursoService.listaTodos();
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PermissaoPerfilRecursoEntity> cadastrarRecurso(@RequestBody PermissaoPerfilRecursoEntity recurso) {
        PermissaoPerfilRecursoEntity novoRecurso = permissaoPerfilRecursoService.inserir(recurso);
        return new ResponseEntity<>(novoRecurso, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissaoPerfilRecursoEntity> buscarRecursoPorId(@PathVariable Long id) {
        return permissaoPerfilRecursoService.buscarPorId(id)
                .map(recurso -> new ResponseEntity<>(recurso, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissaoPerfilRecursoEntity> alterarRecurso(@PathVariable Long id, @RequestBody PermissaoPerfilRecursoEntity recurso) {
        try {
            PermissaoPerfilRecursoEntity recursoAtualizado = permissaoPerfilRecursoService.alterar(id, recurso);
            return new ResponseEntity<>(recursoAtualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirRecurso(@PathVariable Long id) {
        permissaoPerfilRecursoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}