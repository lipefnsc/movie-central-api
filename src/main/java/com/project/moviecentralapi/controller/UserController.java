package com.project.moviecentralapi.controller;

import com.project.moviecentralapi.dto.FavoriteMovieDTO;
import com.project.moviecentralapi.dto.UserDTO;
import com.project.moviecentralapi.model.FavoriteMovie;
import com.project.moviecentralapi.model.User;
import com.project.moviecentralapi.service.FavoriteMovieService;
import com.project.moviecentralapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FavoriteMovieService favoriteMovieService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setEmail(userDTO.getEmail());

        User createdUser = userService.createUser(newUser);

        UserDTO responseDTO = new UserDTO();
        responseDTO.setUsername(createdUser.getUsername());
        responseDTO.setEmail(createdUser.getEmail());

        return ResponseEntity.status(201).body(responseDTO);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> findByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        UserDTO responseDTO = new UserDTO();
        responseDTO.setUsername(user.getUsername());
        responseDTO.setEmail(user.getEmail());
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/{username}/favorites")
    public ResponseEntity<FavoriteMovie> addFavoriteMovie(
            @PathVariable String username,
            @RequestBody FavoriteMovieDTO favoriteMovieDTO) {

        FavoriteMovie favorite = favoriteMovieService.addFavoriteMovie(
                username,
                favoriteMovieDTO.getTmdbMovieId()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(favorite);
    }

}
