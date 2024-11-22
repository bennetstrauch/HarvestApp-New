package spring.backend.service.interfaces;

import spring.backend.entity.dto.UserDTO;

public interface UserService {
    public void createUser(UserDTO userDTO);
    public UserDTO getUser(int id);
}
