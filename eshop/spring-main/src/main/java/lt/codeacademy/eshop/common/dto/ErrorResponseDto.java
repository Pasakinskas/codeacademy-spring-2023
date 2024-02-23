package lt.codeacademy.eshop.common.dto;

import lombok.Builder;

@Builder
public record ErrorResponseDto(int errorCode, String errorMessage) {
}
