package lt.codeacademy.eshop.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lt.codeacademy.eshop.common.dto.ErrorResponseDto;
import lt.codeacademy.eshop.common.product.dto.ProductDto;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface ProductControllerSpec {

  @Operation(
    summary = "Get all products data",
    description = "Get all products data. And more information here, bla bla bla.")
  @ApiResponses(value = {
    @ApiResponse(
      responseCode = "200",
      description = "Successfully get product data",
      content = @Content(
        mediaType = "application/json",
        array = @ArraySchema(schema = @Schema(implementation = ProductDto.class))
      )
    ),
    @ApiResponse(
      responseCode = "500",
      description = "Server error",
      content = @Content(
        mediaType = "application/json",
        array = @ArraySchema(schema = @Schema(implementation = ErrorResponseDto.class))
      )
    )
  })
  @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
  List<ProductDto> getAllProducts();
}
