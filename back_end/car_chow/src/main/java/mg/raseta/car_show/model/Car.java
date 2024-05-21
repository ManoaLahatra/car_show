package mg.raseta.car_show.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carTypeId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "power", nullable = false)
    private int power;

    @Column(name = "place_number", nullable = false)
    private int placeNumber;

    @Column(name = "status", nullable = false)
    private boolean status;

    /*
     * TODO: Foreign key:
     *  - brand
     *  - motor_type
     *  - type
     */

}