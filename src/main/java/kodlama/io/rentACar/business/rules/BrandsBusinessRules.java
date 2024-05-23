package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.exception.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandsBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists (String name){
        if (this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand name already exists");
        }
    }


}
