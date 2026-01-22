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

    public Usuario buscarUsuarioPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("E-mail não identificado")
        );
    }

    public void deletarUsuarioPorEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, Usuario usuario) {
    Usuario usuarioEntity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não identificado"));

    if (usuario.getEmail() != null) {
        usuarioEntity.setEmail(usuario.getEmail());
    }

    if (usuario.getNome() != null) {
        usuarioEntity.setNome(usuario.getNome());
    }

    repository.save(usuarioEntity);
    
    }
}