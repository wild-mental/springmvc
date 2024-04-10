package ac.su.springmvc.service;

import ac.su.springmvc.domain.User;
import ac.su.springmvc.exception.UserNotFoundException;
import ac.su.springmvc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User updatedUser) {
        User existingUser = findById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepository.save(existingUser);
    }

    public User patch(Long id, User patchUser) {
        User existingUser = findById(id);
        if (patchUser.getName() != null) {
            existingUser.setName(patchUser.getName());
        }
        if (patchUser.getEmail() != null) {
            existingUser.setEmail(patchUser.getEmail());
        }
        return userRepository.save(existingUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}