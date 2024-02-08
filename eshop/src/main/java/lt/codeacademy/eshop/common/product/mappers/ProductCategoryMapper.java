package lt.codeacademy.eshop.common.product.mappers;

import lt.codeacademy.eshop.common.mapper.Mapper;
import lt.codeacademy.eshop.common.product.dto.ProductCategoryDto;
import lt.codeacademy.eshop.jpa.entities.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper implements Mapper<ProductCategory, ProductCategoryDto> {


  @Override
  public ProductCategoryDto toDto(ProductCategory entity) {
    return ProductCategoryDto.builder()
      .id(entity.getId())
      .name(entity.getName())
      .build();
  }

  @Override
  public ProductCategory fromDto(ProductCategoryDto productCategoryDto) {
    return ProductCategory.builder()
      .id(productCategoryDto.getId())
      .name(productCategoryDto.getName())
      .build();
  }
}
