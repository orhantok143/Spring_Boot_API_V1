package orhanSpringBoot.api.business.concrets;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orhanSpringBoot.api.business.abstracts.ModelService;
import orhanSpringBoot.api.business.requests.CreateModelRequest;
import orhanSpringBoot.api.business.requests.UpdateModel;
import orhanSpringBoot.api.business.respones.GetAllModelResponse;
import orhanSpringBoot.api.core.utilities.mappers.ModelMapperService;
import orhanSpringBoot.api.dataAccess.abstarcts.ModelRepository;
import orhanSpringBoot.api.entites.concrets.Model;

@Service
public class ModelManager implements ModelService {
  @Autowired
  private ModelRepository modelRepository;
  @Autowired
  private ModelMapperService modelMapperService;    


    @Override
    public List<GetAllModelResponse> getAll() {
     List<Model> models = modelRepository.findAll();
     List<GetAllModelResponse> getAllModelResponse  = models.stream().map(model->this.modelMapperService
     .forResponse().map(model, GetAllModelResponse.class)).collect(Collectors.toList());
     return getAllModelResponse;

    }


    @Override
    public GetAllModelResponse getModelById(int id) {
      Optional<Model> model = modelRepository.findById(id);
      GetAllModelResponse getAllModelResponse = modelMapperService.forResponse().map(model, GetAllModelResponse.class);
      return getAllModelResponse;
    }


    @Override
    public void add(CreateModelRequest createModelRequest) {
      Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
      modelRepository.save(model);
    }


    @Override
    public void update(int id, UpdateModel updateModel) {
      List<Model> models = modelRepository.findAll();

      for (Model  model: models) {
            if (model.getId()==id) {
               this.modelMapperService.forRequest().map(updateModel, Model.class);
                modelRepository.save(model);
            }
        }
    }


    @Override
    public void delete(int id) {
      modelRepository.deleteById(id);
    }


}
