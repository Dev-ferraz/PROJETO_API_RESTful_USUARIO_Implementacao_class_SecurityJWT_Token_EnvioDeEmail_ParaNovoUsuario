package conexao_api_teste_01.cadastra_api.UsuarioController.DTO;

public class AcessDTO {
    private String token;
    private String username;

    // Construtor com token e username
    public AcessDTO(String token, String username) {
        this.token = token;
        this.username = username;
    }

    // Construtor com apenas a mensagem de erro (exemplo)
    public AcessDTO(String mensagemErro) {
        this.token = null;  // ou qualquer valor padrão
        this.username = mensagemErro;  // Aqui você pode armazenar a mensagem de erro
    }

    // Getters e setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}