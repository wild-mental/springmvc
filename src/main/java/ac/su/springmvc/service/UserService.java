package ac.su.springmvc.service;

import ac.su.springmvc.domain.User;
import ac.su.springmvc.domain.UserBmiDTO;
import ac.su.springmvc.domain.UserDTO;
import ac.su.springmvc.exception.UserNotFoundException;
import ac.su.springmvc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO findById(Long id) {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return UserDTO.fromEntity(foundUser);
    }

    public UserBmiDTO findUserBmiById(Long id) {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return UserBmiDTO.fromEntity(foundUser);
    }

    public UserDTO save(UserDTO user) {
        User savedUser = userRepository.save(user.toEntity());
        return UserDTO.fromEntity(savedUser);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public UserDTO update(Long id, UserDTO updatedUser) {
        User existingUser = findUserById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        User savedUser = userRepository.save(existingUser);
        return UserDTO.fromEntity(savedUser);
    }

    public UserDTO patch(Long id, UserDTO patchUser) {
        User existingUser = findUserById(id);
        if (patchUser.getName() != null) {
            existingUser.setName(patchUser.getName());
        }
        if (patchUser.getEmail() != null) {
            existingUser.setEmail(patchUser.getEmail());
        }
        User savedUser = userRepository.save(existingUser);
        return UserDTO.fromEntity(savedUser);
    }

    public List<UserDTO> findAll() {
        List<User> allUsers = userRepository.findAll();
        return convertToUserDTOList(allUsers);
    }

    public static List<UserDTO> convertToUserDTOList(List<User> userList) {
        return userList.stream()
            .map(UserDTO::fromEntity)
            .collect(Collectors.toList());
    }

    public List<UserBmiDTO> findAllUserWithBmi() {
        List<User> allUsers = userRepository.findAll();
        return convertToUserBmiDTOList(allUsers);
    }

    public static List<UserBmiDTO> convertToUserBmiDTOList(List<User> userList) {
        return userList.stream()
            .map(UserBmiDTO::fromEntity)
            .collect(Collectors.toList());
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}