package kh.edu.istad.restfulapi.service.impl;

import kh.edu.istad.restfulapi.dto.CategoryCreateRequest;
import kh.edu.istad.restfulapi.dto.CategoryResponse;
import kh.edu.istad.restfulapi.dto.UserResponse;
import kh.edu.istad.restfulapi.model.Category;
import kh.edu.istad.restfulapi.model.User;
import kh.edu.istad.restfulapi.repository.CategoryRepository;
import kh.edu.istad.restfulapi.service.CategoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Getter
@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServicempl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse create(CategoryCreateRequest categoryCreateRequest) {

        Category category = new Category();
        category.setName(categoryCreateRequest.name());
        category.setIcon(categoryCreateRequest.icon());

        Category savedCategory = categoryRepository.save(category);
        log.info("After saving category: {}", category.getId());

        return CategoryResponse.builder()
                .id(savedCategory.getId())
                .name(savedCategory.getName())
                .icon(savedCategory.getIcon())
                .build();
    }

    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                        .icon(category.getIcon())
                        .build())
                        .toList();

    }

    @Override
    public void deleteById(Integer id) {
        Category category =  categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category not found"
                ));
        categoryRepository.delete(category);
        log.info("After delete user: {}",id);
    }

    @Override
    public CategoryResponse getById(Integer id) {
        return categoryRepository.findById(id)
                .map(category -> CategoryResponse.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .icon(category.getIcon())
                        .build())
                .orElseThrow(() -> new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "Resource not found"));
    }
}






