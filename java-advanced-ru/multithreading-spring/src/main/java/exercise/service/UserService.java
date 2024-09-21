package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> show(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> create(User user) {
        return userRepository.save(user);
    }

    public Mono<User> update(User user, Long id) {
        return userRepository.findById(id)
                .flatMap(u -> {
                    user.setId(id);
                    return userRepository.save(user);
                });
        //var userUpdate = new User(user.getFirstName(), user.getLastName(), user.getEmail());
        //userUpdate.setId(id);
        //return userRepository.save(userUpdate);
    }

    public Mono<Void> delete(Long id) {
        return userRepository.deleteById(id);
    }
    // END
}
