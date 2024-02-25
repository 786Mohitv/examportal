package com.exam.repo;

import com.exam.model.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Mohit Verma
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
