package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.ICategoryDao;
import mx.com.gm.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Override
   @Transactional(readOnly = true)
    public List<Category> listarCategorias() {
        return (List<Category>) categoryDao.findAll();
    }

    @Override
    @Transactional
    public Category guardar(Category category) {
        return categoryDao.save(category);
    }

    @Override
    @Transactional
    public void eliminar(Category category) {
        categoryDao.delete(category);
    }

    @Override
    @Transactional(readOnly = true)
    public Category encontrarCategoria(Category category) {
         return categoryDao.findById(category.getId()).orElse(null);
    }
    
}
