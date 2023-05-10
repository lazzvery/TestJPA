package test.hello.spring.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> illegalStateErrorHandler(IllegalStateException e) {
        log.error("Error msg = {}", e.getMessage());
        return ResponseEntity.badRequest().body(e.getMessage());
    }   // 중복 회원 에러 핸들링

}
