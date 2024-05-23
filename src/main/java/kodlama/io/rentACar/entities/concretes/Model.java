package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="Models")
@Data   // @Getter , @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
    @Id    // primary key
    @GeneratedValue( strategy = GenerationType.IDENTITY)   // otomatik artar
    @Column (name = "id")  //    veritabanındaki karşılığı
    private int id ;

    @Column (name = "name")  // veritabanındaki karşılığı
    private String name;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;

}
