package orhanSpringBoot.api.dataAccess.abstarcts;

import org.springframework.data.jpa.repository.JpaRepository;

import orhanSpringBoot.api.entites.concrets.Model;


public interface ModelRepository extends JpaRepository<Model,Integer> {

}
