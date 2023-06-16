package it.addvalue.chronos.core.exception;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError implements Serializable {
  private static final long serialVersionUID = 7591427952185571482L;

  private HttpStatus status;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
  private LocalDateTime timestamp;

  private String message;
  private List<String> errors;

  private ApiError() {
    timestamp = LocalDateTime.now();
  }

  public ApiError(HttpStatus status, String message, List<String> errors) {
    this();
    this.status = status;
    this.message = message;
    this.errors = errors;
  }

  public ApiError(HttpStatus status, String message, String error) {
    this();
    this.status = status;
    this.message = message;
    errors = Arrays.asList(error);
  }
}
