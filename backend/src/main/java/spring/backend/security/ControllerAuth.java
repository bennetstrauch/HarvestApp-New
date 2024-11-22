//package spring.backend.security;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController("api/v1/users")
//public class ControllerAuth {
//    private final AuthService authService;
//
//    public ControllerAuth(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
//        var loginResponse = authService.login(loginRequest);
//        return new ResponseEntity<LoginResponseDTO>(
//                loginResponse, HttpStatus.OK);
//    }
//
//}
