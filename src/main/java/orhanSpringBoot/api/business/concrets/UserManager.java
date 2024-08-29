package orhanSpringBoot.api.business.concrets;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import orhanSpringBoot.api.business.abstracts.UserService;
import orhanSpringBoot.api.business.requests.CreateUser;
import orhanSpringBoot.api.business.requests.UpdateUser;
import orhanSpringBoot.api.business.respones.GetAllUser;
import orhanSpringBoot.api.core.utilities.mappers.ModelMapperService;
import orhanSpringBoot.api.dataAccess.abstarcts.UserRepository;
import orhanSpringBoot.api.entites.concrets.User;


@Service
public class UserManager implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapperService modelMapperService;

       @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<GetAllUser> getAllUser() {
        List<User> users = userRepository.findAll();
        List<GetAllUser> getAllUsers = users.stream()
                                        .map(user->this.modelMapperService.forResponse()
                                        .map(user, GetAllUser.class))
                                        .collect(Collectors.toList());
        return getAllUsers;
    }

    @Override
    public GetAllUser getUserById(int id) {
       List<User> users = userRepository.findAll();
       GetAllUser getAllUser = new GetAllUser();
        for (User user : users) {
            if (user.getId()==id) {
                getAllUser = modelMapperService.forResponse().map(user, GetAllUser.class);
            }
        }
        return getAllUser;
    }

    @Override
    public void addUser(CreateUser createUser) {
        User user= modelMapperService.forRequest().map(createUser, User.class);

        System.out.println("password::" + createUser.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void update(int id, UpdateUser updateUser) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getId()==id) {   
                modelMapperService.forRequest().map(updateUser,User.class);
                userRepository.save(user);
            }
        }
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

}
