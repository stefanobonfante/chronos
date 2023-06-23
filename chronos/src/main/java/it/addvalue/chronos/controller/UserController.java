package it.addvalue.chronos.controller;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.UserDto;
import it.addvalue.chronos.model.entity.User;
import it.addvalue.chronos.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
  @Autowired private final UserServiceImpl service;

  @GetMapping(path = "/api/users/attivi")
  public ResponseEntity<List<UserDto>> getListaUtenti(@RequestBody User autenitcato)
      throws EsecuzioneErrataException {
    return ResponseEntity.ok(service.getListaUtenti(autenitcato));
  }
}
