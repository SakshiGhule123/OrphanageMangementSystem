package com.anudip.training.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler {
	
    public ResponseEntity<ErrorMessage> handleAdminException(AdminIdNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    public ResponseEntity<ErrorMessage> handleAdopterException(AdopterIdNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    public ResponseEntity<ErrorMessage> handleChildException(ChildIdNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    public ResponseEntity<ErrorMessage> handleDonorException(DonorIdNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    public ResponseEntity<ErrorMessage> handleFacilityException(FacilityIdNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    public ResponseEntity<ErrorMessage> handleOrphanageException(OrphanageIdNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    public ResponseEntity<ErrorMessage> handleStaffException(StaffIdNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }

    public ResponseEntity<ErrorMessage> handleUserException(UserIdNotFoundException ex, WebRequest request) {
        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
    }
}
