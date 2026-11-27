package kh.edu.istad.restfulapi.service;

import kh.edu.istad.restfulapi.dto.CategoryCreateRequest;
import kh.edu.istad.restfulapi.dto.CategoryResponse;
import kh.edu.istad.restfulapi.dto.UserResponse;


import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryResponse create (CategoryCreateRequest categoryCreateRequest);
    List<CategoryResponse> getAll();
    void deleteById(Integer id);
    CategoryResponse getById(Integer id);
}
