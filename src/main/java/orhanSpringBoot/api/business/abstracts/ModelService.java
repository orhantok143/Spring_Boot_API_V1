package orhanSpringBoot.api.business.abstracts;


import java.util.List;

import orhanSpringBoot.api.business.requests.CreateModelRequest;
import orhanSpringBoot.api.business.requests.UpdateModel;
import orhanSpringBoot.api.business.respones.GetAllModelResponse;

public interface ModelService {
    List<GetAllModelResponse> getAll();
    GetAllModelResponse getModelById(int id);
    void add( CreateModelRequest createModelRequest);
    void update(int id,UpdateModel updateModel);
    void delete(int id);
}
