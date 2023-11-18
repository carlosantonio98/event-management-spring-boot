package mx.com.gm.domain;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "events")
public class Event implements Serializable{
    
    public Event() {
        
    }
    
    public Event(String name, String description, LocalDateTime startDate, LocalDateTime endDate, String location, double price, int capacity, String requirements, Long categoryFk) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.price = price;
        this.capacity = capacity;
        this.requirements = requirements;
        this.categoryFk = categoryFk;
    }
    
    // Versión para el control de serialización
    private static final long serialVersionUID = 1L;
    
    // Campo que representa el ID de la persona
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private double price;
    private int capacity;
    private String requirements;
    private Long categoryFk;
}
