package orhanSpringBoot.api.dataAccess.abstarcts;

import org.springframework.data.jpa.repository.JpaRepository;

import orhanSpringBoot.api.entites.concrets.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
}
