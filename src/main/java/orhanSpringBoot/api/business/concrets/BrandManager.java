package orhanSpringBoot.api.business.concrets;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import orhanSpringBoot.api.business.abstracts.BrandService;
import orhanSpringBoot.api.business.requests.CreateBrandRequest;
import orhanSpringBoot.api.business.requests.UpdateBrandRequest;
import orhanSpringBoot.api.business.respones.GetAllBrandsRespons;
import orhanSpringBoot.api.business.rules.BrandBusinessRules;
import orhanSpringBoot.api.core.utilities.mappers.ModelMapperService;
import orhanSpringBoot.api.dataAccess.abstarcts.BrandRepository;
import orhanSpringBoot.api.entites.concrets.Brand;


@Service
public class BrandManager implements BrandService  {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelMapperService modelMapperService;
    @Autowired
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsRespons> getAll() {
        List<Brand> brands =  brandRepository.findAll();
        List<GetAllBrandsRespons> getAllBrandsResponses = brands.stream()
        .map(brand->this.modelMapperService.forResponse().map(brand, GetAllBrandsRespons.class))
        .collect(Collectors.toList());

        return  getAllBrandsResponses;
    }

    @Override
    public GetAllBrandsRespons getBrandById(int id) {
        Optional<Brand> brand =  brandRepository.findById(id);
        GetAllBrandsRespons getAllBrandsRespons = this.modelMapperService.forResponse()
        .map(brand,GetAllBrandsRespons.class);
        return getAllBrandsRespons;
        
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest){
        this.brandBusinessRules.ifCheckedBrandNameExists(createBrandRequest.getName());
        Brand brand = modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brandRepository.save(brand);

    }

    @Override
    public void update(int id ,UpdateBrandRequest updateBrandRequest) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
    
        if (brandOptional.isPresent()) {
            Brand brand = brandOptional.get();
            
            // Map the updateBrandRequest to the existing Brand entity
            modelMapperService.forRequest().map(updateBrandRequest, brand);
            
            // Save the updated brand
            brandRepository.save(brand);
        } else {
            throw new EntityNotFoundException("Brand not found with id: " + id);
        }
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }



}
