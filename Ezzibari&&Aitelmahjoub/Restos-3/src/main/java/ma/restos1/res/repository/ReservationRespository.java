package ma.restos1.res.repository;

import ma.restos1.res.entities.Reservation;
import ma.restos1.res.entities.Tables_Restos;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
@Transactional
public interface ReservationRespository extends JpaRepository<Reservation,Integer> {

}
