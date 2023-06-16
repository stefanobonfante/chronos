package it.addvalue.chronos.core.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

  @GetMapping(path = "/swagger")
  public void redirectToSwaggerUI(HttpServletResponse response) throws IOException {
    response.sendRedirect("swagger-ui/index.html");
  }
}
