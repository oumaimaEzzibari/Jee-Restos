package ma.restos1.res.repository;

import ma.restos1.res.entities.utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<utilisateur,Integer> {
    List<utilisateur> findAll();
}
