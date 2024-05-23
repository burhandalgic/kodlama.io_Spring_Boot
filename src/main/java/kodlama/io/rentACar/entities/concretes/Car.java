package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="Cars")
@Data   // @Getter , @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

    @Id    // primary key
    @GeneratedValue( strategy = GenerationType.IDENTITY)   // otomatik artar
    @Column (name = "id")  //    veritabanındaki karşılığı
    private int id ;

    @Column(name = "plate" , unique = true)
    private String plate;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name="modelYear")
    private int modelYear;

    @Column(name="state")
    private int state; // 1-Available  2-Rented  3-Maintenance

    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;


}
