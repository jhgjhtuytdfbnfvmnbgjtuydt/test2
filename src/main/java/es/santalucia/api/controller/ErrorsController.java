package es.santalucia.api.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import es.santalucia.api.model.Error;

import org.springframework.boot.web.servlet.error.ErrorController;


@ControllerAdvice
@RestController
public class ErrorsController implements ErrorController {

  private static final String PATH = "/error";

  @RequestMapping(value = PATH)
  public Error error(HttpServletRequest request) {
    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
    // Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
    Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
    // String excType = (String) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE);
    // if ("java.lang.Exception".equals(excType)) {
    //    exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
    // }

    return new Error(
        statusCode, exception == null ? null : exception.getMessage());
  }

  @Override
  public String getErrorPath() {
    return PATH;
  }
}
