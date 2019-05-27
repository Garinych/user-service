package md.codefactory.userservice.domain;

import lombok.Data;
import md.codefactory.userservice.domain.enums.RoleName;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @SequenceGenerator(name = "role_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    @Column(name = "id")
    private Long id;


    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    @NotEmpty
    private RoleName name;
}
