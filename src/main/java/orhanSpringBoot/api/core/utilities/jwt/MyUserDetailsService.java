package orhanSpringBoot.api.core.utilities.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import orhanSpringBoot.api.dataAccess.abstarcts.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Normalde burada veritabanından kullanıcıyı bulup döndürürüz.
        // Şimdilik basit bir kullanıcı nesnesi döndürüyoruz.
        orhanSpringBoot.api.entites.concrets.User user = userRepository.findByUsername(username);
        System.err.println("MyuserServise geldi::" + user.getUsername());

        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}

