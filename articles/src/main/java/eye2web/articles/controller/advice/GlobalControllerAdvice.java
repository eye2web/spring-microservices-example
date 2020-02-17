package eye2web.articles.controller.advice;

import eye2web.articles.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalControllerAdvice {

    @ExceptionHandler({NotFoundException.class, ConversionFailedException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Void> handleNotFoundException(final Exception ex, final WebRequest webRequest) {

        log.debug(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
