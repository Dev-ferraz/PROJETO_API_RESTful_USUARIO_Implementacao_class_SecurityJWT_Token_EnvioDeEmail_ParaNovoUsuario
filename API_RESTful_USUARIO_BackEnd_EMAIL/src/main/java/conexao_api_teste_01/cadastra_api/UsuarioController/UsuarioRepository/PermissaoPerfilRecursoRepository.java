package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity.PermissaoPerfilRecursoEntity;

public interface PermissaoPerfilRecursoRepository extends JpaRepository<PermissaoPerfilRecursoEntity, Long>  {

}
