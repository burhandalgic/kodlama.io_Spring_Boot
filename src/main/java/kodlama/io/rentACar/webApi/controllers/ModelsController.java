package kodlama.io.rentACar.webApi.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreatBrandRequest;
import kodlama.io.rentACar.business.requests.CreatModelRequest;
import kodlama.io.rentACar.business.responces.GetAllBrandsResponce;
import kodlama.io.rentACar.business.responces.GetAllModelsResponce;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponce> getAll(){
        return modelService.getAll();
    }
    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED) // 201 döndürsün diye
    public void add (@RequestBody @Valid CreatModelRequest creatModelRequest ){
        modelService.add(creatModelRequest);
    }



}
