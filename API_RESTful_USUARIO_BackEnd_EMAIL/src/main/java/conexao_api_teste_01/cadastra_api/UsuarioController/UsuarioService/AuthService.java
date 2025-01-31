package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import conexao_api_teste_01.cadastra_api.UsuarioController.DTO.AcessDTO;
import conexao_api_teste_01.cadastra_api.UsuarioController.DTO.AuthenticationDTO;
import conexao_api_teste_01.cadastra_api.UsuarioController.Security.Validacao_JWT.JwtUtils;


@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(AuthenticationDTO authDto) {
        try {
            // Cria mecanismo de credenciais para o Spring
            UsernamePasswordAuthenticationToken userAuth = 
                new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());
            
            // Prepara mecanismo para autenticação
            Authentication authentication = authenticationManager.authenticate(userAuth);
            
            // Busca usuário autenticado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();
            
            // Gera o token JWT
            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);
            
            // Cria DTO de acesso e retorna
            AcessDTO accessDto = new AcessDTO(token, userAuthenticate.getUsername());
            return accessDto;

        } catch (BadCredentialsException e) {
            // Retorna erro de credenciais inválidas
            return new AcessDTO("Credenciais inválidas");
        }
    }
}