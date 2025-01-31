package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity.PermissaoPerfilRecursoEntity;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioRepository.PermissaoPerfilRecursoRepository;

@Service
public class PermissaoPerfilRecursoService {
    @Autowired
    private final PermissaoPerfilRecursoRepository permissaoPerfilRecursoRepository;


    public PermissaoPerfilRecursoService(PermissaoPerfilRecursoRepository permissaoPerfilRecursoRepository) {
        this.permissaoPerfilRecursoRepository = permissaoPerfilRecursoRepository;
    }

    public List<PermissaoPerfilRecursoEntity> listaTodos() {
        return permissaoPerfilRecursoRepository.findAll();
    }

    public Optional<PermissaoPerfilRecursoEntity> buscarPorId(Long id) {
        return permissaoPerfilRecursoRepository.findById(id);
    }

    public PermissaoPerfilRecursoEntity inserir(PermissaoPerfilRecursoEntity permissaoPerfilRecurso) {
        return permissaoPerfilRecursoRepository.save(permissaoPerfilRecurso);
    }

    public PermissaoPerfilRecursoEntity alterar(Long id, PermissaoPerfilRecursoEntity permissaoPerfilRecursoAtualizado) {
        return permissaoPerfilRecursoRepository.findById(id)
            .map(permissaoPerfilRecurso -> {
                permissaoPerfilRecurso.setPerfil(permissaoPerfilRecursoAtualizado.getPerfil());
                permissaoPerfilRecurso.setRecurso(permissaoPerfilRecursoAtualizado.getRecurso());
                return permissaoPerfilRecursoRepository.save(permissaoPerfilRecurso);
            })
            .orElseThrow(() -> new IllegalArgumentException("Recurso não encontrado com o ID: " + id));
    }

    public void excluir(Long id) {
        permissaoPerfilRecursoRepository.deleteById(id);
    }
}
