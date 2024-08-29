package orhanSpringBoot.api.dataAccess.abstarcts;

import org.springframework.data.jpa.repository.JpaRepository;

import orhanSpringBoot.api.entites.concrets.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer>{
    boolean existsByName(String name);

}
