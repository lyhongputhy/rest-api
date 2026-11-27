package kh.edu.istad.restfulapi.repository;

import kh.edu.istad.restfulapi.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> id(Integer id);

    boolean checkById(Integer id);

    void deleteOne(Integer id);
}
