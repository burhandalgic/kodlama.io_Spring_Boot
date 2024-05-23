package kodlama.io.rentACar.business.concretes;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreatModelRequest;
import kodlama.io.rentACar.business.responces.GetAllBrandsResponce;
import kodlama.io.rentACar.business.responces.GetAllModelsResponce;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service  // Bu sınıf bir business nesnesidir
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponce> getAll() {

        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponce> modelsResponces = models.stream().
                map(model ->
                        this.modelMapperService.forResponse().
                                map(model,GetAllModelsResponce.class)).toList();
        return modelsResponces;

    }

    @Override
    public void add( CreatModelRequest creatModelRequest) {
        Model model = this.modelMapperService.forRequest().map(creatModelRequest,Model.class);
        // arada manuel mappleme yapılabilir
        this.modelRepository.save(model);
    }
}
