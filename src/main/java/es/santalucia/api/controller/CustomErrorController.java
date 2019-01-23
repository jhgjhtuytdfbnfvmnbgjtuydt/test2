package es.santalucia.api.controller;

import es.santalucia.api.model.ErrorJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class CustomErrorController implements ErrorController {

private static final String PATH = "/error";

@Value("${custom-error-controller.debug}")
private boolean debug;

@Bean
public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    return new PropertySourcesPlaceholderConfigurer();
}

@Autowired
private ErrorAttributes errorAttributes;

@RequestMapping(value = PATH)
ResponseEntity<ErrorJson> error(WebRequest webRequest, HttpServletResponse response){
    return ResponseEntity.status(response.getStatus())
            .body(
                    new ErrorJson(response.getStatus(), getErrorAttributes(webRequest, debug)
                    )
            );
}

@Override
public String getErrorPath(){
    return PATH;
}

private Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
    return errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
}
}



// @RestController
// @PropertySource("classpath:application.properties") // custom-error-controller.debug place in file and set true/false
// @Configuration
// public class CustomErrorController implements ErrorController {

//   private static final String PATH = "/error";


//   @Bean
//   public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
//     return new PropertySourcesPlaceholderConfigurer();
//   }

//   @Autowired
//   private ErrorAttributes errorAttributes;

//   @RequestMapping(value = PATH)
//   ResponseEntity<ErrorJson> error(HttpServletRequest request, HttpServletResponse response) {
//     return ResponseEntity.status(response.getStatus())
//         .body(new ErrorJson(response.getStatus(), getErrorAttributes(request, debug)));
//   }

//   @Override
//   public String getErrorPath() {
//     return PATH;
//   }

//   private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
//     RequestAttributes requestAttributes = new ServletRequestAttributes(request);
//     return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
//   }
// }
