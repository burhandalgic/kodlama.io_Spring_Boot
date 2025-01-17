package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatModelRequest {
    @NotNull
    @NotBlank
    @Size(min=2, max=30)
    private String name;

    @NotNull
    @NotBlank
    private int brandId;

}
