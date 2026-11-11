package kh.edu.istad.restfulapi.dto;

import java.util.UUID;

public record UserRespone(UUID id,
        String fullName,
        Boolean isActive) {


}
