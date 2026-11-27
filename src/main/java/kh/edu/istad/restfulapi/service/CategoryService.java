package kh.edu.istad.restfulapi.service;

import kh.edu.istad.restfulapi.dto.CategoryCreateRequest;
import kh.edu.istad.restfulapi.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse create (CategoryCreateRequest categoryCreateRequest);
    List<CategoryResponse> getAll();
    void deleteById(Integer id);
    CategoryResponse getById(Integer id);
}
