package com.example.proyectdg.service

import com.example.evaluacion.model.Event
import com.example.evaluacion.repository.EventRepository
//import com.example.proyectdg.model.Event
//import com.example.proyectdg.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class EventService {
    @Autowired
    lateinit var eventRepository: EventRepository

    fun save (event: Event):Event{
        return eventRepository.save(event)
    }
    fun list ():List<Event>{
        return eventRepository.findAll()
    }

    fun update(event:Event):Event{
        try{
            eventRepository.findById(event.id)
                ?: throw Exception ("El Id no existe")
            return eventRepository.save(event)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(event:Event): Event {
        try{
            val response = eventRepository.findById(event.id)
                ?: throw Exception("ID no existe")
            response.apply {
                description=event.description
            }
            return eventRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}