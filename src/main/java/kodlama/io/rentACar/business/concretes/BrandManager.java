package kodlama.io.rentACar.business.concretes;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreatBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responces.GetAllBrandsResponce;
import kodlama.io.rentACar.business.responces.GetByIdBrandResponce;
import kodlama.io.rentACar.business.rules.BrandsBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service  // Bu sınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandsBusinessRules brandsBusinessRules;


   @Override
    public List<GetAllBrandsResponce> getAll() {

       List<Brand> brands = brandRepository.findAll();
       /*
       List<GetAllBrandsResponce> newList = new ArrayList<>();
        for (Brand brand : brands){
             GetAllBrandsResponce newResponce = new GetAllBrandsResponce();
            newResponce.setId(brand.getId());
            newResponce.setName(brand.getName());
            newList.add(newResponce);
        }
        */
       List<GetAllBrandsResponce> brandsResponse = brands.stream().
               map(brand ->
                       this.modelMapperService.forResponse().
                               map(brand,GetAllBrandsResponce.class)).toList();
        return brandsResponse;
    }
    @Override
    public GetByIdBrandResponce getById(int id) {

       /*List<Brand> brands = brandRepository.findAll();
        for (Brand brand:brands){
            if (brand.getId()==id){
                GetByIdBrandResponce getByIdBrandResponce =
                        this.modelMapperService.forResponse().map(brand,GetByIdBrandResponce.class);
                return getByIdBrandResponce;
            }
        }
        return null;
        */
        Brand brand = brandRepository.findById(id).orElseThrow(); // optional döndürür
        GetByIdBrandResponce getByIdBrandResponce =
                this.modelMapperService.forResponse().map(brand,GetByIdBrandResponce.class);
        return getByIdBrandResponce;
    }
    @Override
    public Brand add( CreatBrandRequest creatBrandRequest) {
       /* Brand brand = new Brand();
        brand.setName(creatBrandRequest.getName());
        */
        this.brandsBusinessRules.checkIfBrandNameExists(creatBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(creatBrandRequest,Brand.class);
        return this.brandRepository.save(brand);
    }
    @Override
    public void delete(int id) {
       /* List<Brand> brands = brandRepository.findAll();
        for (Brand brand : brands){
            if (id==brand.getId()){
                this.brandRepository.delete(brand);
                return;
            }
        }
        */
        this.brandRepository.deleteById(id);
    }
    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand); // id olduğu için update işlemi yapar
    }





}
