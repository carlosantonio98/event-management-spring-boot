package mx.com.gm.web;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Category;
import mx.com.gm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        try {
            List<Category> categories = categoryService.listarCategorias();

            System.out.println(categories);

            if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
    
    @PostMapping("/categories")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        try {
            Category _category = categoryService.guardar(new Category(category.getName()));
            return new ResponseEntity<>(_category, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category) {
        try {
            Category _category = categoryService.guardar(category);
            return new ResponseEntity<>(_category, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
        try {
            Category category = new Category();
            category.setId(id);
            
            categoryService.eliminar(category);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
     
    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> eventById(@PathVariable("id") long id) {
        try {
            Category category = new Category();
            category.setId(id);

            Category _category = categoryService.encontrarCategoria(category);

            return new ResponseEntity<>(_category, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
