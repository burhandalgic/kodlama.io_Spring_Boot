package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreatBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responces.GetAllBrandsResponce;
import kodlama.io.rentACar.business.responces.GetByIdBrandResponce;
import kodlama.io.rentACar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponce> getAll();
    GetByIdBrandResponce getById(int id);
    Brand add (CreatBrandRequest creatBrandRequest);
    void delete (int id);
    void update (UpdateBrandRequest updateBrandRequest);


}
