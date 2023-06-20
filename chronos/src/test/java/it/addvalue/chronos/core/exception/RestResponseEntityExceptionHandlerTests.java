package it.addvalue.chronos.core.exception;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import it.addvalue.chronos.ChronosApplication;

@AutoConfigureMockMvc
@SpringBootTest
@ContextConfiguration(
    classes = {
      ChronosApplication.class,
      RestResponseEntityExceptionHandlerTests.TestController.class
    })
@WebAppConfiguration
public class RestResponseEntityExceptionHandlerTests {
  @Autowired private MockMvc mockMvc;

  @Test
  public void handleMethodArgumentNotValid() throws Exception {
    // FIXME: adding test implementation here
    assertTrue(true);
  }

  @Test
  public void handleMissingServletRequestParameter() throws Exception {
    mockMvc
        .perform(get("/handleMissingServletRequestParameter"))
        .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
        .andExpect(redirectedUrl(null))
        .andExpect(header().string("Content-Type", equalTo("application/json")))
        .andExpect(content().string(containsString("\"status\":\"BAD_REQUEST\"")))
        .andExpect(
            content()
                .string(
                    containsString(
                        "\"message\":\"Required null parameter 'null' is not present\",\"errors\":[\"null parameter is missing\"]")));
  }

  @Test
  public void handleConstraintViolation() throws Exception {
    mockMvc
        .perform(get("/handleConstraintViolation"))
        .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
        .andExpect(redirectedUrl(null))
        .andExpect(header().string("Content-Type", equalTo("application/json")))
        .andExpect(content().string(containsString("\"status\":\"BAD_REQUEST\"")))
        .andExpect(
            content()
                .string(
                    containsString(
                        "\"message\":\"handleConstraintViolation.param: "
                            + "must not be null\",\"errors\":[\"it.addvalue.chronos.core.exception"
                            + ".RestResponseEntityExceptionHandlerTests$TestController "
                            + "handleConstraintViolation.param: must not be null\"]")));
  }

  @Test
  public void handleMethodArgumentTypeMismatch() throws Exception {
    mockMvc
        .perform(get("/handleMethodArgumentTypeMismatch"))
        .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
        .andExpect(redirectedUrl(null))
        .andExpect(header().string("Content-Type", equalTo("application/json")))
        .andExpect(content().string(containsString("\"status\":\"BAD_REQUEST\"")))
        .andExpect(
            content()
                .string(
                    containsString(
                        "\"message\":\"Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer'\",\"errors\":[\" should be of type java.lang.Integer\"]")));
  }

  @Test
  public void handleNoHandlerFoundException() throws Exception {
    mockMvc
        .perform(get("/handleNoHandlerFoundException"))
        .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
        .andExpect(redirectedUrl(null))
        .andExpect(header().string("Content-Type", equalTo("application/json")))
        .andExpect(content().string(containsString("\"status\":\"NOT_FOUND\"")))
        .andExpect(
            content()
                .string(
                    containsString(
                        "\"message\":\"No handler found for null null\",\"errors\":[\"No handler found for null null\"]")));
  }

  @Test
  public void handleHttpRequestMethodNotSupported() throws Exception {
    // FIXME: adding test implementation here
    assertTrue(true);
  }

  @Test
  public void handleHttpMediaTypeNotSupported() throws Exception {
    mockMvc
        .perform(get("/handleHttpMediaTypeNotSupported"))
        .andExpect(status().is(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()))
        .andExpect(redirectedUrl(null))
        .andExpect(header().string("Content-Type", equalTo("application/json")))
        .andExpect(content().string(containsString("\"status\":\"UNSUPPORTED_MEDIA_TYPE\"")))
        .andExpect(
            content()
                .string(
                    containsString(
                        "\"message\":\"\",\"errors\":[\"null media type is not supported. Supported media types are \"")));
  }

  @Test
  public void handleAll() throws Exception {
    mockMvc
        .perform(get("/handleAll"))
        .andExpect(status().is(HttpStatus.INTERNAL_SERVER_ERROR.value()))
        .andExpect(redirectedUrl(null))
        .andExpect(header().string("Content-Type", equalTo("application/json")))
        .andExpect(content().string(containsString("\"status\":\"INTERNAL_SERVER_ERROR\"")))
        .andExpect(
            content().string(containsString("\"message\":null,\"errors\":[\"error occurred\"]")));
  }

  @Validated
  @RestController
  public static class TestController {
    @GetMapping(path = "/handleMethodArgumentNotValid")
    public void handleMethodArgumentNotValid() {
      // FIXME: adding implementation here
    }

    @GetMapping(path = "/handleMissingServletRequestParameter")
    public void handleMissingServletRequestParameter()
        throws MissingServletRequestParameterException {
      throw new MissingServletRequestParameterException(null, null);
    }

    @GetMapping(path = "/handleConstraintViolation")
    public void handleConstraintViolation(@NotNull String param) {}

    @GetMapping(path = "/handleMethodArgumentTypeMismatch")
    public void handleMethodArgumentTypeMismatch(String param)
        throws MethodArgumentTypeMismatchException, NoSuchMethodException, SecurityException {
      throw new MethodArgumentTypeMismatchException(
          "",
          Integer.class,
          "",
          new MethodParameter(
              TestController.class.getMethod("handleMethodArgumentTypeMismatch", String.class), -1),
          null);
    }

    @GetMapping(path = "/handleNoHandlerFoundException")
    public void handleNoHandlerFoundException() throws NoHandlerFoundException {
      throw new NoHandlerFoundException(null, null, null);
    }

    @GetMapping(path = "/handleHttpRequestMethodNotSupported")
    public void handleHttpRequestMethodNotSupported() {
      // FIXME: adding implementation here
    }

    @GetMapping(path = "/handleHttpMediaTypeNotSupported")
    public void handleHttpMediaTypeNotSupported() throws HttpMediaTypeNotSupportedException {
      throw new HttpMediaTypeNotSupportedException("");
    }

    @GetMapping(path = "/handleAll")
    public void handleAll() throws Exception {
      throw new Exception();
    }
  }
}
