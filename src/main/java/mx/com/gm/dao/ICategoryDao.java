package mx.com.gm.dao;

import mx.com.gm.domain.Category;

import org.springframework.data.repository.CrudRepository;

public interface ICategoryDao extends CrudRepository<Category, Long> {
    
}
