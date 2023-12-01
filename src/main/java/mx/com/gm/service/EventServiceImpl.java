package mx.com.gm.service;

import mx.com.gm.dao.IEventDao;
import java.util.List;
import mx.com.gm.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventServiceImpl implements EventService {
    
    @Autowired
    private IEventDao eventDao;

    @Override
    @Transactional(readOnly = true)
    public List<Event> listarEventos() {
        return (List<Event>) eventDao.findAll();
    }

    @Override
    @Transactional
    public Event guardar(Event event) {
        return eventDao.save(event);
    }

    @Override
    @Transactional
    public void eliminar(Event event) {
        eventDao.delete(event);
    }

    @Override
    @Transactional(readOnly = true)
    public Event encontrarEvento(Event event) {
        return eventDao.findById(event.getId()).orElse(null);
    }
    
}
