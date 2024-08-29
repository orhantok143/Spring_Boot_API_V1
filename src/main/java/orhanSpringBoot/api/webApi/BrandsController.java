package orhanSpringBoot.api.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import orhanSpringBoot.api.business.abstracts.BrandService;
import orhanSpringBoot.api.business.requests.CreateBrandRequest;
import orhanSpringBoot.api.business.requests.UpdateBrandRequest;
import orhanSpringBoot.api.business.respones.GetAllBrandsRespons;


@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;
    
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping("")
    public List<GetAllBrandsRespons> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetAllBrandsRespons getBrandById(@PathVariable int id){
        return brandService.getBrandById(id);
    }
    
    @PostMapping("")
    public void add(@Valid @RequestBody  CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @Valid  @RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(id,updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        brandService.delete(id);
    }   
}
