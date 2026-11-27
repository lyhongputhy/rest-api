package kh.edu.istad.restfulapi.service.impl;

import kh.edu.istad.restfulapi.dto.UserCreateRequest;
import kh.edu.istad.restfulapi.dto.UserResponse;
import kh.edu.istad.restfulapi.model.User;
import kh.edu.istad.restfulapi.repository.UserRepository;
import kh.edu.istad.restfulapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {

        return null;
    }


    @Override
    public List<UserResponse> getAll() {
        return null;
    }

    @Override
    public UserResponse getById(UUID id) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {
        // validate user ID

    }


}