package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreatBrandRequest;
import kodlama.io.rentACar.business.requests.CreatModelRequest;
import kodlama.io.rentACar.business.responces.GetAllBrandsResponce;
import kodlama.io.rentACar.business.responces.GetAllModelsResponce;
import kodlama.io.rentACar.business.responces.GetByIdBrandResponce;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponce> getAll();
    void add (CreatModelRequest creatModelRequest);
}
