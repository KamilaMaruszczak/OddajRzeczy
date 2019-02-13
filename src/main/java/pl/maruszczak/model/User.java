package pl.maruszczak.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import pl.maruszczak.validator.UniqueEmail;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    @NotBlank

    @Column(unique = true)
    @UniqueEmail
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String phone;


}
