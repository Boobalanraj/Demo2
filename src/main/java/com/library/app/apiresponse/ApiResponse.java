package com.library.app.apiresponse;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class ApiResponse<T> {

    private HttpStatus status;
    private String message;
    private T data;
    private T error;

    public ApiResponse(HttpStatus status, String message, T data,T error) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.error = error;
    }

}
