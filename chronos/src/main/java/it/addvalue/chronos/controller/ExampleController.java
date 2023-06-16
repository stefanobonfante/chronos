package it.addvalue.chronos.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.addvalue.chronos.model.dto.UserDto;

@RestController
public class ExampleController {

  @GetMapping(path = "/users")
  public ResponseEntity<List<UserDto>> groupsGranted() {
    return ResponseEntity.ok(
        Arrays.asList(new UserDto("addvalue", 1), new UserDto("teamfacotry", 1)));
  }
}
