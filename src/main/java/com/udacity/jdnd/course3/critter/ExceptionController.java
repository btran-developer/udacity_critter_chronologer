package com.udacity.jdnd.course3.critter;

import com.udacity.jdnd.course3.critter.error_response.NotFoundErrorResponse;
import com.udacity.jdnd.course3.critter.error_response.ValidationErrorResponse;
import com.udacity.jdnd.course3.critter.pet.exception.PetNotFoundException;
import com.udacity.jdnd.course3.critter.schedule.exception.ScheduleNotFoundException;
import com.udacity.jdnd.course3.critter.user.exception.CustomerNotFoundException;
import com.udacity.jdnd.course3.critter.user.exception.EmployeeNotFoundException;
import com.udacity.jdnd.course3.critter.user.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse(errors);

        return new ResponseEntity(validationErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {
            CustomerNotFoundException.class, EmployeeNotFoundException.class, UserNotFoundException.class,
            ScheduleNotFoundException.class, PetNotFoundException.class})
    public ResponseEntity<NotFoundErrorResponse> handleNotFoundExceptions(Exception ex) {
        NotFoundErrorResponse notFoundErrorResponse = new NotFoundErrorResponse(ex.getMessage());

        return new ResponseEntity(notFoundErrorResponse, HttpStatus.NOT_FOUND);
    }
}
