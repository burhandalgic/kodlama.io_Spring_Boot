package kodlama.io.rentACar.business.responces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponce {
    private int id;
    private String name;
    private String brandName;

}
