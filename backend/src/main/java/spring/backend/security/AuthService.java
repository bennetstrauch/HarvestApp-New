package spring.backend.security;


public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO loginRequest);
}
