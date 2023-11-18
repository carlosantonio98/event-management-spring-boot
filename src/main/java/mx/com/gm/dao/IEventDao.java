package mx.com.gm.dao;

import mx.com.gm.domain.Event;

import org.springframework.data.repository.CrudRepository;

public interface IEventDao extends CrudRepository<Event, Long> {
    
}
