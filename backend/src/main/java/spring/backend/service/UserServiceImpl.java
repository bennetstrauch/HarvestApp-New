package spring.backend.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import spring.backend.entity.User;
import spring.backend.entity.dto.UserDTO;
import spring.backend.repository.UserRepo;


@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }


    public void createUser(UserDTO userDTO) {
        //# check for uniqueness here for effc.?
        // do with modelmapper?

        User newUser = new User();
            newUser.setName(userDTO.getName());
            newUser.setEmail(userDTO.getEmail());
            newUser.setPassword(userDTO.getPassword());

        userRepo.save(newUser);
    }

    public UserDTO getUser(int id) {
            User user = userRepo.findById(id).get();
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }
}
