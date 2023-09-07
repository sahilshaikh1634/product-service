package dev.sahil.productservices.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@Getter
public class ExceptionDto {
    private HttpStatusCode statusCode;
    private String Message;
}
