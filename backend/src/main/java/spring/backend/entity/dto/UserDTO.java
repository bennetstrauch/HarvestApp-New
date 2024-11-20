package spring.backend.entity.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {
    String name;
    String email;
    String password;
}
