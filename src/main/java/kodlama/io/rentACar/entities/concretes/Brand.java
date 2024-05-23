package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name="Brands")
@Data   // @Getter , @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Brand {


    @Id    // primary key
    @GeneratedValue ( strategy = GenerationType.IDENTITY)   // otomatik artar
    @Column (name = "id")  //    veritabanındaki karşılığı
    private int id ;

    @Column (name = "name")  // veritabanındaki karşılığı
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;

}
