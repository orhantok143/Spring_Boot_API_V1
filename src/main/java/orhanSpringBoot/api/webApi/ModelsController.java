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
import orhanSpringBoot.api.business.abstracts.ModelService;
import orhanSpringBoot.api.business.requests.CreateModelRequest;
import orhanSpringBoot.api.business.requests.UpdateModel;
import orhanSpringBoot.api.business.respones.GetAllModelResponse;


@RestController
@RequestMapping("api/model")
public class ModelsController {
    private ModelService modelService;

    public ModelsController(ModelService modelService) {
        this.modelService = modelService;
    }


    @GetMapping("")
    public List<GetAllModelResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetAllModelResponse getModelById(@PathVariable int id){
        return modelService.getModelById(id);
    }

    @PostMapping("")
    public void create(@RequestBody() @Valid CreateModelRequest createModelRequest){
        modelService.add(createModelRequest);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody() @Valid UpdateModel updateModel){
        modelService.update(id, updateModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        modelService.delete(id);
    }

}
