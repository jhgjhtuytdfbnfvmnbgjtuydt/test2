package es.santalucia.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.autoconfigure.web.ErrorAttributes;
// import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity.BodyBuilder;
import es.santalucia.api.exception.GenericResponseHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class OverrideErrorWhitePage implements ErrorController {
  private static final String ERROR_PATH = "/error";

  @ResponseBody
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @RequestMapping(value = ERROR_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
  public GenericResponseHandler<Object> handleError() {
    // return ResponseBodyBuilder.notFoundHandler();
    return null;
  }

  @Override
  public String getErrorPath() {
    return ERROR_PATH;
  }
}


// @RestController
// public class OverrideErrorWhitePage implements ErrorController {

//   private static final String PATH = "/error";

//   @RequestMapping(value = PATH)
//   public String error() {
//     return "Error handling";
//   }

//   @Override
//   public String getErrorPath() {
//     return PATH;
//   }
// }
