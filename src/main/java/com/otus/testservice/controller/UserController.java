package com.otus.testservice.controller;


import com.otus.testservice.domain.UserDTO;
import com.otus.testservice.domain.response.HealthResponse;
import com.otus.testservice.domain.response.SimpeResponse;
import com.otus.testservice.entity.User;
import com.otus.testservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/")
@RestController
public class UserController {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(UserService userService) {
        this.modelMapper = new ModelMapper();
        this.userService = userService;
    }

    @GetMapping(path = "/health")
    public ResponseEntity<HealthResponse> getHealth() {
            return ResponseEntity.ok(new HealthResponse("OK"));
    }

    @PostMapping(path = "/user")
    public ResponseEntity<SimpeResponse> addUser(@RequestBody UserDTO user) {
        try {
            userService.save(convertToEntity(user));
            return ResponseEntity.ok(new SimpeResponse("OK", ""));
        } catch (Exception ex) {
            return ResponseEntity.ok(new SimpeResponse("ERROR", ex.getLocalizedMessage()));
        }
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Long userId) {
        try {
            return ResponseEntity.ok(convertToDto(userService.findById(userId)));
        } catch (Exception ex) {
            return ResponseEntity.ok(new UserDTO());
        }
    }

    @DeleteMapping (path = "/user/{userId}")
    public ResponseEntity<SimpeResponse> deleteUser(@PathVariable("userId") Long userId) {
        try {
            userService.deleteById(userId);
            return ResponseEntity.ok(new SimpeResponse("OK", ""));
        } catch (Exception ex) {
            return ResponseEntity.ok(new SimpeResponse("ERROR", ex.getLocalizedMessage()));
        }
    }

    @PutMapping(path = "/user")
    public ResponseEntity<SimpeResponse> editUser(@RequestBody UserDTO user) {
        try {
            userService.save(convertToEntity(user));
            return ResponseEntity.ok(new SimpeResponse("OK", ""));
        } catch (Exception ex) {
            return ResponseEntity.ok(new SimpeResponse("ERROR", ex.getLocalizedMessage()));
        }
    }

    private UserDTO convertToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    private User convertToEntity(UserDTO user) {
        return modelMapper.map(user, User.class);
    }


}
