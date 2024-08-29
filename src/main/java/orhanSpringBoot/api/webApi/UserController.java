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

import orhanSpringBoot.api.business.abstracts.UserService;
import orhanSpringBoot.api.business.requests.CreateUser;
import orhanSpringBoot.api.business.requests.UpdateUser;
import orhanSpringBoot.api.business.respones.GetAllUser;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<GetAllUser> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public GetAllUser getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping("")
    public void create(@RequestBody CreateUser createUser){
        userService.addUser(createUser);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UpdateUser updateUser){
        userService.update(id, updateUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
}
