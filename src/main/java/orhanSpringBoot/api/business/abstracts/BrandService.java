package orhanSpringBoot.api.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import orhanSpringBoot.api.business.requests.CreateBrandRequest;
import orhanSpringBoot.api.business.requests.UpdateBrandRequest;
import orhanSpringBoot.api.business.respones.GetAllBrandsRespons;

@Repository
public interface BrandService {
    List<GetAllBrandsRespons> getAll();
    GetAllBrandsRespons getBrandById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(int id,UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
