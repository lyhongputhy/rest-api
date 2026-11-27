package kh.edu.istad.restfulapi.service.impl;

import kh.edu.istad.restfulapi.dto.UserCreateRequest;
import kh.edu.istad.restfulapi.dto.UserResponse;
import kh.edu.istad.restfulapi.model.User;
import kh.edu.istad.restfulapi.repository.UserRepository;
import kh.edu.istad.restfulapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;



    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {
        User user = new User();
        user.setFullName(userCreateRequest.fullName());
        user.setUsername(userCreateRequest.username());
        user.setPassword(userCreateRequest.password());
        user.setIsActive(true);

        User savedUser = userRepository.save(user);
        log.info("After saving user: {}", user.getId());

        return UserResponse.builder()
                .id(savedUser.getId())
                .fullName(savedUser.getFullName())
                .isActive(savedUser.getIsActive())
                .build();
    }


    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .fullName(user.getFullName())
                        .isActive(user.getIsActive())
                        .build())
                        .toList();

    }

    @Override
    public UserResponse getById(UUID id) {

        return userRepository.findById(id)
                .map(user -> UserResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .isActive(user.getIsActive())
                .build())
                .orElseThrow(() -> new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "Resource not found"));

    }

    @Override
    public void deleteById(UUID id) {
      User user =  userRepository.findById(id)
              .orElseThrow(() -> new ResponseStatusException(
                      HttpStatus.NOT_FOUND,
                      "User not found"
              ));
      userRepository.delete(user);
      log.info("After delete user: {}",id);
    }



}