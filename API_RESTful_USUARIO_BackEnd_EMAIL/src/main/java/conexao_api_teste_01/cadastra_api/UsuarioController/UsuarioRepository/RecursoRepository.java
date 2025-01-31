package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity.RecursoEntity;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long>{

}

