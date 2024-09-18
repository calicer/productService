package dev.vishal.productservice.dtos;

import dev.vishal.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSingleProductResponseDto {

    private Product product;

}
