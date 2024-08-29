package orhanSpringBoot.api.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import orhanSpringBoot.api.business.requests.CreateUser;
import orhanSpringBoot.api.business.requests.UpdateUser;
import orhanSpringBoot.api.business.respones.GetAllUser;


@Repository
public interface UserService {
    List<GetAllUser> getAllUser();
    GetAllUser getUserById(int id);
    void addUser(CreateUser createUser);
    void update(int id, UpdateUser updateUser);
    void delete(int id);
}
