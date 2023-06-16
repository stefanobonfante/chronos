package it.addvalue.chronos.core.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SwaggerController.class)
public class SwaggerControllerTests {

  @Autowired private MockMvc mockMvc;

  @Test
  public void redirectToSwaggerUITests() throws Exception {
    mockMvc
        .perform(get("/swagger"))
        .andDo(print())
        .andExpect(status().is(HttpStatus.FOUND.value()))
        .andExpect(redirectedUrl("swagger-ui/index.html"))
        .andExpect(header().string("Location", equalTo("swagger-ui/index.html")));
  }
}
