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

import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity.RecursoEntity;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService.RecursoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/recurso")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public ResponseEntity<List<RecursoEntity>> listarRecursos() {
        List<RecursoEntity> recursos = recursoService.listaTodos();
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RecursoEntity> cadastrarRecurso(@RequestBody RecursoEntity recurso) {
        RecursoEntity novoRecurso = recursoService.inserir(recurso);
        return new ResponseEntity<>(novoRecurso, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecursoEntity> buscarRecursoPorId(@PathVariable Long id) {
        return recursoService.buscarPorId(id)
                .map(recurso -> new ResponseEntity<>(recurso, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecursoEntity> alterarRecurso(@PathVariable Long id, @RequestBody RecursoEntity recurso) {
        try {
            RecursoEntity recursoAtualizado = recursoService.alterar(id, recurso);
            return new ResponseEntity<>(recursoAtualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirRecurso(@PathVariable Long id) {
        recursoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}