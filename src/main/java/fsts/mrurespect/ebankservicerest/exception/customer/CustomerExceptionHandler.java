package fsts.mrurespect.ebankservicerest.exception.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponce> handleException(@Autowired CustumerNotFoundException exception){
        CustomerErrorResponce errorResponse =new CustomerErrorResponce();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponce> handleException(@Autowired EmailAlreadyInUseException exception){
        CustomerErrorResponce errorResponse =new CustomerErrorResponce();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponce> handleException(@Autowired Exception exception){
        CustomerErrorResponce errorResponse =new CustomerErrorResponce();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
