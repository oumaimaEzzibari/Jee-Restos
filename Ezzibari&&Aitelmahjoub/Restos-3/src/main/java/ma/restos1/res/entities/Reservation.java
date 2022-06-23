package ma.restos1.res.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Reservation;

    @Column(name="Table",nullable = false)
    private String Table;

    @Column(name="Name",nullable = false)
    private String Name;

    @Column(name="Message",nullable = false)
    private String Message;

    @Column(name="Reponse",nullable = false)
    private String Reponse="en attente";
}
