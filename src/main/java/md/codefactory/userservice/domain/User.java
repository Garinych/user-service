package md.codefactory.userservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @SequenceGenerator(name = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @Column(name = "id")
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "lastName")
    String lastName;

    @Column(name = "email")
    String email;

    @Column(name = "phone_number")
    Integer phoneNumber;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

}
