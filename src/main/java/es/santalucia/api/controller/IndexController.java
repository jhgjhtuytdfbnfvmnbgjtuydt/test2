package es.santalucia.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.servlet.error.ErrorController;

@RestController
public class IndexController implements ErrorController {

  private static final String PATH = "/error";

  @RequestMapping(value = PATH)
  public String error() {
    return "Error handling";
  }

  @Override
  public String getErrorPath() {
    return PATH;
  }
}
