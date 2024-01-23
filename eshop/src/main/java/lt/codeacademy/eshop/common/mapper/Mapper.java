package lt.codeacademy.eshop.common.mapper;

/**
 * Use this as standard for all mappers.
 * @param <E> - Any Entity
 * @param <DTO> - Any DTO
 */
public interface Mapper<E, DTO> {

  DTO toDto(E entity);
  E fromDto(DTO dto);
}
