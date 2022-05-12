package br.com.juandev.forum.config.validation;

import br.com.juandev.forum.config.validation.dto.ErrorFormDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerAdvice {

    private final MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(SearchNotFoundException.class)
    public String handleNotFound(SearchNotFoundException exception){
        return exception.getMessage();
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorFormDTO> handle(MethodArgumentNotValidException exception) {

        var fieldErrors = exception.getBindingResult().getFieldErrors();

        var dtoReturn = fieldErrors.stream()
                .map(fieldError -> {
                    var message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
                    return new ErrorFormDTO(fieldError.getField(), message);
                }).collect(Collectors.toList());

        return dtoReturn;

    }

}
