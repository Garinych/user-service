package md.codefactory.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private String errorMessage = "errorMessage";

    @ExceptionHandler({EmailAlreadyExistException.class})
    public ResponseEntity<Map<String,String>> emailAlreadyExist(EmailAlreadyExistException e){
        Map<String,String> responce = new HashMap<>();
        responce.put(errorMessage, e.getMessage());
        return new ResponseEntity<>(responce, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({PhoneNumberAlreadyExistException.class})
    public ResponseEntity<Map<String,String>> emailAlreadyExist(PhoneNumberAlreadyExistException e){
        Map<String,String> responce = new HashMap<>();
        responce.put(errorMessage, e.getMessage());
        return new ResponseEntity<>(responce, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({UsernameAlreadyExistException.class})
    public ResponseEntity<Map<String,String>> emailAlreadyExist(UsernameAlreadyExistException e){
        Map<String,String> responce = new HashMap<>();
        responce.put(errorMessage, e.getMessage());
        return new ResponseEntity<>(responce, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ProfileNotFountException.class})
    public ResponseEntity<Map<String,String>> emailAlreadyExist(ProfileNotFountException e){
        Map<String,String> responce = new HashMap<>();
        responce.put(errorMessage, e.getMessage());
        return new ResponseEntity<>(responce, HttpStatus.NOT_FOUND);
    }
}
