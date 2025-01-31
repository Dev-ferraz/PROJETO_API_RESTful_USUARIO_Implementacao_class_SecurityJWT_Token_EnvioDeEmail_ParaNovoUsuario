package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity.PerfilEntity;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioRepository.PerfilRepository;

@Service
public class PerfilService {
    @Autowired
    private final PerfilRepository perfilRepository;

    
    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    // Método para listar todos os perfis
    public List<PerfilEntity> listarTodos() {
        return perfilRepository.findAll();
    }

    // Método para buscar um perfil pelo ID
    public Optional<PerfilEntity> buscarPorId(Long id) {
        return perfilRepository.findById(id);
    }

    // Método para inserir um novo perfil
    public PerfilEntity inserir(PerfilEntity perfil) {
        return perfilRepository.save(perfil);
    }

    // Método para atualizar um perfil existente
    public PerfilEntity atualizar(Long id, PerfilEntity perfilAtualizado) {
        return perfilRepository.findById(id)
            .map(perfil -> {
                perfil.setDescricao(perfilAtualizado.getDescricao());
                return perfilRepository.save(perfil);
            })
            .orElseThrow(() -> new IllegalArgumentException("Perfil não encontrado com o ID: " + id));
    }

    // Método para excluir um perfil pelo ID
    public void excluir(Long id) {
        perfilRepository.deleteById(id);
    }
}