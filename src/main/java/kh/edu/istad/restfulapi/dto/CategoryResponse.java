package kh.edu.istad.restfulapi.dto;

import lombok.Builder;

@Builder
public record CategoryResponse(Integer id, String name, String icon) {
}
