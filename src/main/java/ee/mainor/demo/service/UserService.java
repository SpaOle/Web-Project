package ee.mainor.demo.service;

import ee.mainor.demo.dto.UserDto;
import ee.mainor.demo.dto.CreateUserRequest;
import ee.mainor.demo.mapper.UserMapper;
import ee.mainor.demo.model.User;
import ee.mainor.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public UserDto create(CreateUserRequest createUserRequest) {
        User User = UserMapper.toEntity(createUserRequest);
        return UserMapper.toDto(userRepository.save(User));
    }

    public UserDto update(Integer id, UserDto UserDto) {
        User User = UserMapper.updateEntity(UserDto, requireUser(id));

        return UserMapper.toDto(userRepository.save(User));
    }

    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(UserMapper::toDto).toList();
    }

    public UserDto findById(Integer id) {
        User User = requireUser(id);
        return UserMapper.toDto(User);
    }

    private User requireUser(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not dount"));
    }

}
