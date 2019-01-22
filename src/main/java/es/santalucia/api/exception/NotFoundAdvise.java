
package es.santalucia.api.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestControllerAdvice;
// import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.util.WebUtils;
// import org.springframework.web.context.request.WebRequest;
// import org.springframework.http.HttpHeaders;
// import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.santalucia.api.exception.NotFoundException;

// import es.santalucia.api.exception.CustomNotFoundException;
// import es.santalucia.api.model.ResponseMsg;


// @ControllerAdvice
// public class RestExceptionHandlerAdvice {
  // /** Provides handling for exceptions throughout this service. */
  // @ExceptionHandler({ UserNotFoundException.class, ContentNotAllowedException.class })
  // public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
  //   HttpHeaders headers = new HttpHeaders();

  //   if (ex instanceof UserNotFoundException) {
  //     HttpStatus status = HttpStatus.NOT_FOUND;
  //     UserNotFoundException unfe = (UserNotFoundException) ex;

  //     return handleUserNotFoundException(unfe, headers, status, request);
  //   } else if (ex instanceof ContentNotAllowedException) {
  //     HttpStatus status = HttpStatus.BAD_REQUEST;
  //     ContentNotAllowedException cnae = (ContentNotAllowedException) ex;

  //     return handleContentNotAllowedException(cnae, headers, status, request);
  //   } else {
  //     HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
  //     return handleExceptionInternal(ex, null, headers, status, request);
  //   }
  // }

  // /** Customize the response for UserNotFoundException. */
  // protected ResponseEntity<ApiError> handleUserNotFoundException(UserNotFoundException ex, HttpHeaders headers,
  //     HttpStatus status, WebRequest request) {
  //   List<String> errors = Collections.singletonList(ex.getMessage());
  //   return handleExceptionInternal(ex, new ApiError(errors), headers, status, request);
  // }

  // /** Customize the response for ContentNotAllowedException. */
  // protected ResponseEntity<ApiError> handleContentNotAllowedException(ContentNotAllowedException ex,
  //     HttpHeaders headers, HttpStatus status, WebRequest request) {
  //   List<String> errorMessages = ex.getErrors().stream()
  //       .map(contentError -> contentError.getObjectName() + " " + contentError.getDefaultMessage())
  //       .collect(Collectors.toList());

  //   return handleExceptionInternal(ex, new ApiError(errorMessages), headers, status, request);
  // }

  /** A single place to customize the response body of all Exception types. */
//   protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers,
//       HttpStatus status, WebRequest request) {
//     if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
//       request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
//     }

//     return new ResponseEntity<>(body, headers, status);
//   }
// }

// @ControllerAdvice
// @RequestMapping("/error")
// public class RestExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

//   @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
//   protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
//     String bodyOfResponse = "This should be application specific";
//     return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
//   }
// }

// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.servlet.ModelAndView;
// import com.spring.mvc.demo.exception.MyException;

// @ControllerAdvice
//  public class RestExceptionHandlerAdvice {

//   // @ExceptionHandler(MyException.class)
//   //   public ModelAndView handleMyException(MyException mex) {
//   //     ModelAndView model = new ModelAndView();
//   //     model.addObject("errCode", mex.getErrCode());
//   //     model.addObject("errMsg", mex.getErrMsg());
//   //     model.setViewName("error/generic_error");
//   //     return model;
//   //   }

//   @ExceptionHandler(Exception.class)
//   public ModelAndView handleException(Exception ex) {
//     ModelAndView model = new ModelAndView();
//     model.addObject("errMsg", "This is a 'Exception.class' message.");
//     model.setViewName("error/generic_error");
//     return model;
//     }
// }


@ControllerAdvice
public class NotFoundAdvise {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public Object processValidationError(NotFoundException ex) {
    String result = ex.getErrorMessage();
    System.out.println("###########" + result);
    return ex;
  }
}
