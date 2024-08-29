package orhanSpringBoot.api.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orhanSpringBoot.api.core.utilities.exceptions.BadRequestException;
import orhanSpringBoot.api.dataAccess.abstarcts.BrandRepository;

@Service
public class BrandBusinessRules {

    @Autowired
    private BrandRepository brandRepository;

    public void ifCheckedBrandNameExists(String name){
        if(brandRepository.existsByName(name)){
           throw new BadRequestException("Brand name already exists");
        }
    }
}
