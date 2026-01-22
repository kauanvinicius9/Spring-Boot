import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Usuário")
@Entity


public class Usuario {
    @Id
    @GenerateValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (name = "email", unique = true)
    private String email;

    @Column (name = "nome")
    private String nome;
}