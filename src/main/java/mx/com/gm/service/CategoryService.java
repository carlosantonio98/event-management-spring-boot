package mx.com.gm.service;

import java.util.List;
import mx.com.gm.domain.Category;

public interface CategoryService {
    
    public List<Category> listarCategorias();
    
    public Category guardar(Category category);
    
    public void eliminar(Category category);

    public Category encontrarCategoria(Category category);
    
}
