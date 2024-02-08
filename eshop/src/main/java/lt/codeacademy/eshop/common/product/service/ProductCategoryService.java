package lt.codeacademy.eshop.common.product.service;

import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.common.product.dto.ProductCategoryDto;
import lt.codeacademy.eshop.common.product.mappers.ProductCategoryMapper;
import lt.codeacademy.eshop.jpa.repositories.ProductCategoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

  private final ProductCategoryRepository productCategoryRepository;
  private final ProductCategoryMapper productCategoryMapper;

  public Set<ProductCategoryDto> getCategories() {
    return productCategoryRepository.findAll().stream()
      .map(productCategoryMapper::toDto)
      .collect(Collectors.toSet());
  }

}
