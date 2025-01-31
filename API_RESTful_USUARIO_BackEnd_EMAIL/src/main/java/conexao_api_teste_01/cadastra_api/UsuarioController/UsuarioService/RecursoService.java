
package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity.RecursoEntity;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioRepository.RecursoRepository;

@Service
public class RecursoService {

    @Autowired
    private final RecursoRepository recursoRepository;

    
    public RecursoService(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    public List<RecursoEntity> listaTodos() {
        return recursoRepository.findAll();
    }

    public Optional<RecursoEntity> buscarPorId(Long id) {
        return recursoRepository.findById(id);
    }

    public RecursoEntity inserir(RecursoEntity recurso) {
        return recursoRepository.save(recurso);
    }

    public RecursoEntity alterar(Long id, RecursoEntity recursoAtualizado) {
        return recursoRepository.findById(id)
            .map(recurso -> {
                recurso.setNome(recursoAtualizado.getNome());
                recurso.setChave(recursoAtualizado.getChave());
                return recursoRepository.save(recurso);
            })
            .orElseThrow(() -> new IllegalArgumentException("Recurso não encontrado com o ID: " + id));
    }

    public void excluir(Long id) {
        recursoRepository.deleteById(id);
    }

}