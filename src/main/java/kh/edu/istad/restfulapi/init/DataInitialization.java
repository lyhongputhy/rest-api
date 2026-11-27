package kh.edu.istad.restfulapi.init;

import jakarta.annotation.PostConstruct;
import kh.edu.istad.restfulapi.model.User;
import kh.edu.istad.restfulapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class DataInitialization {
    private final UserRepository userRepository;

    @PostConstruct
    void init(){
        if (userRepository.count() == 0){
            // insert user into m1_db
            // 1. Create entity object
            User user1 = new User();
            user1.setFullName("Administrator");
            user1.setUsername("admin");
            user1.setPassword("qwer");
            user1.setIsActive(true);

            User user2 = new User();
            user2.setFullName("Editor");
            user2.setUsername("editor");
            user2.setPassword("qwer");
            user2.setIsActive(true);

            User user3 = new User();
            user3.setFullName("Puthy Lyhong");
            user3.setUsername("puthylyhong");
            user3.setPassword("qwer");
            user3.setIsActive(false);


            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
        }

    }
}
