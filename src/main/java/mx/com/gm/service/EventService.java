package mx.com.gm.service;

import java.util.List;
import mx.com.gm.domain.Event;

// Contrato con los metodos que vamos ha implementar
public interface EventService {
 
    public List<Event> listarEventos();
    
    public Event guardar(Event event);
    
    public void eliminar(Event event);

    public Event encontrarEvento(Event event);
}
