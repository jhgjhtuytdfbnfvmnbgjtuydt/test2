package es.santalucia.api.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
@Component
public class Error {

  @JsonProperty("status")
  private Integer status;

  @JsonProperty("error")
  private String error;

  public Error(int status, String error) {
    super();
    this.status = status;
    this.error = error;
  }
}
