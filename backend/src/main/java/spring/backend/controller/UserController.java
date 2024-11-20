package spring.backend.controller;

import org.springframework.web.bind.annotation.*;
import spring.backend.entity.dto.UserDTO;
import spring.backend.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    // final?
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


   @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable int id) {
       System.out.println("getting user with id: " +id);

       return userService.getUser(id);
   }

   @PostMapping("/register")
    public void createUser(@RequestBody UserDTO userDTO) {
       System.out.println("creating user");

        // return id?
       userService.createUser(userDTO);
   }


//   @GetMapping("/crops")
//    public String getUserCrops(@PathVariable String id) {
//       System.out.println("getting crops for user with id: " +id);
//
//       return "crops for user with id: " +id;
//   }

}
