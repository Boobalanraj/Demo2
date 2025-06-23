package com.library.app.exception;

import com.library.app.apiresponse.ApiResponse;
import com.library.app.exception.customexception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> handleBadRequest(BadRequestException exception){
        ApiResponse errorResponse = new ApiResponse();
        errorResponse.setData(null);
        errorResponse.setMessage("Bad Request");
        errorResponse.setError(exception.getMessage());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

//    @ExceptionHandler(InvalidCredentialException.class)
//    public ResponseEntity<ResponseApi> handleInvalidRequest(InvalidCredentialException exception){
//        ResponseApi errorResponse = new ResponseApi();
//        errorResponse.setData(null);
//        errorResponse.setMessage("Bad Request");
//        errorResponse.setError(exception.getMessage());
//        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    @ExceptionHandler(NoDataPresentException.class)
//    public ResponseEntity<ResponseApi> handleNoDataRequest(NoDataPresentException exception){
//        ResponseApi errorResponse = new ResponseApi();
//        errorResponse.setData(null);
//        errorResponse.setMessage("Bad Request");
//        errorResponse.setError(exception.getMessage());
//        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//
//    @ExceptionHandler(UnauthoziedException.class)
//    public ResponseEntity<ResponseApi> handleUnauthoziedRequest(UnauthoziedException exception){
//        ResponseApi errorResponse = new ResponseApi();
//        errorResponse.setData(null);
//        errorResponse.setMessage("Bad Request");
//        errorResponse.setError(exception.getMessage());
//        errorResponse.setStatus(HttpStatus.UNAUTHORIZED);
//
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
//    }
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ApiResponse> handleValidation(MethodArgumentNotValidException exception) {
    Map<String, String> fieldErrors = new HashMap<>();
    exception.getBindingResult().getFieldErrors().forEach(fieldError ->
            fieldErrors.put(fieldError.getField(), fieldError.getDefaultMessage()));

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ApiResponse<>(HttpStatus.BAD_REQUEST, "Validation Failed", null, fieldErrors));
}
}
