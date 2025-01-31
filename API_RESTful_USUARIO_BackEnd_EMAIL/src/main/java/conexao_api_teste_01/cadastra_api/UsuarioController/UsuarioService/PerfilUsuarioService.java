package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity.PerfilUsuarioEntity;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioRepository.PerfilUsuarioRepository;



@Service
public class PerfilUsuarioService {
    
    @Autowired
    private final PerfilUsuarioRepository perfilUsuarioRepository;

    
    public PerfilUsuarioService(PerfilUsuarioRepository perfilUsuarioRepository) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
    }

    
    public List<PerfilUsuarioEntity> listarTodos() {
        return perfilUsuarioRepository.findAll();
    }

    
    public Optional<PerfilUsuarioEntity> buscarPorId(Long id) {
        return perfilUsuarioRepository.findById(id);
    }

    
    public PerfilUsuarioEntity inserir(PerfilUsuarioEntity perfilUsuario) {
        return perfilUsuarioRepository.save(perfilUsuario);
    }

    
    public PerfilUsuarioEntity alterar(Long id, PerfilUsuarioEntity perfilUsuarioAtualizado) {
        return perfilUsuarioRepository.findById(id)
            .map(perfilUsuario -> {
                perfilUsuario.setUsuario(perfilUsuarioAtualizado.getUsuario());
                perfilUsuario.setPerfil(perfilUsuarioAtualizado.getPerfil());
                return perfilUsuarioRepository.save(perfilUsuario);
            })
            .orElseThrow(() -> new IllegalArgumentException("Perfil de usuário não encontrado com o ID: " + id));
    }

    
    public void excluir(Long id) {
        perfilUsuarioRepository.deleteById(id);
    }


}