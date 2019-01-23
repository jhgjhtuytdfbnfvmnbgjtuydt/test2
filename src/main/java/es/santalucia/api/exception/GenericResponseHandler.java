package es.santalucia.api.exception;

// import com.fasterxml.jackson.annotation.JsonAutoDetect;
// import com.fasterxml.jackson.annotation.JsonIgnore;
// import lombok.AccessLevel;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import org.springframework.stereotype.Component;

// import java.util.Map;

// @JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
// @getter(AccessLevel.PUBLIC)
// @Setter(AccessLevel.PROTECTED)
// @NoArgsConstructor
// @component
// public class ErrorJson {

//   private Integer status;
//   private String error;

//   @JsonIgnore
//   private String message;
//   private String timeStamp;
//   private String trace;

//   public ErrorJson(int status, Map<String, Object> errorAttributes) {
//     this.status = status;
//     this.error = (String) errorAttributes.get("error");
//     this.message = (String) errorAttributes.get("message");
//     this.timeStamp = errorAttributes.get("timestamp").toString();
//     this.trace = (String) errorAttributes.get("trace");
//   }
// }

// // public class GenericResponseHandler<T> {
// //   private String responseCode;
// //   private String responseMessage;
// //   private T data;
// // }

