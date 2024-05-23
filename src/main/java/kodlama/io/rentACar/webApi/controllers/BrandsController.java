package kodlama.io.rentACar.webApi.controllers;
import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreatBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responces.GetAllBrandsResponce;
import kodlama.io.rentACar.business.responces.GetByIdBrandResponce;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor

public class BrandsController {
    private BrandService brandService;


    @GetMapping()
    public List<GetAllBrandsResponce> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponce getById (@PathVariable int id) {   return  brandService.getById(id);
    }



    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED) // 201 döndürsün diye
    public ResponseEntity<Brand> add (@RequestBody @Valid CreatBrandRequest creatBrandRequest){

        Brand brandresult = brandService.add(creatBrandRequest);
        return ResponseEntity.ok(brandresult);
    }

    @PutMapping //update bu şekilde yapılır
    public void update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest){
        brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete ( @PathVariable int id){
        brandService.delete(id);
    }


}
