import com.kauan.user_login.business;

import org.springframework.stereotype.Service;

@Service 
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;

    }

    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);

    }

    public Usuario buscarUsuarioPorEmail(String emai,l)

}