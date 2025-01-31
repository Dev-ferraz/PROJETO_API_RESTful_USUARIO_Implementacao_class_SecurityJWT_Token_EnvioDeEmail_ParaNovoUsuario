package conexao_api_teste_01.cadastra_api.UsuarioController.UsuarioEntity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name  = "perfilUsuario")
public class PerfilUsuarioEntity {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    //Muitos Pra Um
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioEntity usuario;


    @ManyToOne
    @JoinColumn(name = "ID_PERFIL")
    private PerfilEntity perfil;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public UsuarioEntity getUsuario() {
        return usuario;
    }


    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }


    public PerfilEntity getPerfil() {
        return perfil;
    }


    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PerfilUsuarioEntity other = (PerfilUsuarioEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }










    
 
    
}
