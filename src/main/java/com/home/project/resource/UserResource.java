package com.home.project.resource;

import com.home.project.model.user.dto.UserDTO;
import com.home.project.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserResource {

    private final UserService userService;

    @PostMapping
    public HttpEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
        log.info("M=createUser, recebendo usário={}", userDTO);
        return ResponseEntity.created(URI.create("/user"+userService.create(userDTO).getId())).build();
    }

    @DeleteMapping
    public HttpEntity<?> deleteUser(@Valid @RequestBody UserDTO userDTO) {
        log.info("M=deleteUser, recebendo usário={}", userDTO);
        userService.delete(userDTO);
        return ResponseEntity.ok().build();
    }
}
