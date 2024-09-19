package dev.vishal.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {

    private String message;
    private String details;
    private int code;
    private String type;

}
