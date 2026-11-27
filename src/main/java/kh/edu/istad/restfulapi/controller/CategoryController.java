package kh.edu.istad.restfulapi.controller;

import kh.edu.istad.restfulapi.dto.CategoryCreateRequest;
import kh.edu.istad.restfulapi.dto.CategoryResponse;

import kh.edu.istad.restfulapi.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryResponse create(@RequestBody CategoryCreateRequest categoryCreateRequest){
        //    @RequestBody for convert JSON to JAVA object

        return categoryService.create(categoryCreateRequest);
    }

    @GetMapping
    public List<CategoryResponse> getAll() {
        return categoryService.getAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        categoryService.deleteById(id);
    }

    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable Integer id) {
        return categoryService.getById(id);
    }


}
