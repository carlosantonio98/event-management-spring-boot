package mx.com.gm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "categories")
public class Category implements Serializable {
    
    public Category() {
        
    }
    
    public Category(String name) {
        this.name = name;
    }
    
    private static final long serialVersionUID = 1L;
 
     // Campo que representa el ID de la persona
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
}
