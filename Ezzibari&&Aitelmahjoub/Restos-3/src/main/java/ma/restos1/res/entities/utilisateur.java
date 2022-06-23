package ma.restos1.res.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity
@Table(name="Utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_User;

    @Column(name="Name",nullable = false)
    private String Name;

    @Column(nullable = false,unique = true)
    private String Phone;

    @Column(name="Ville",nullable = true)
    private String Ville;

    @Column(name="Email",nullable = false)
    private String Email;

    @Column(name="Date_Naissance",nullable = false)
    private String Date_Naissance;

    @Column(name="Password",nullable = false,unique = true)
    private String Password;

}
