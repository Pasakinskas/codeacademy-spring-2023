package lt.codeacademy.eshop.product.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.eshop.product.dao.ProductCategoryRepository;
import lt.codeacademy.eshop.product.dto.ProductCategoryDto;
import lt.codeacademy.eshop.product.mappers.ProductCategoryMapper;
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
