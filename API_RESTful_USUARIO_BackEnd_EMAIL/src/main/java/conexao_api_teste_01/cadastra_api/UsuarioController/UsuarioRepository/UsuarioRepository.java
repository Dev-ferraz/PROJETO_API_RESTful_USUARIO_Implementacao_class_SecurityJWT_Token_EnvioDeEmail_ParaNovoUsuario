package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioRepository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity.UsuarioEntity;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long>   {
    boolean existsByLogin(String login);
    boolean existsByEmail(String email);
    Optional<UsuarioEntity> findByLogin(String login);

}