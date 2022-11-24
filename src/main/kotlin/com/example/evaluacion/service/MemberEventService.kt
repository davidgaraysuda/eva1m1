package com.example.proyectdg.service

import com.example.evaluacion.model.MemberEvent
import com.example.evaluacion.repository.MemberEventRepository
//import com.example.proyectdg.model.Event
//import com.example.proyectdg.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class MemberEventService {
    @Autowired
    lateinit var memberEventRepository: MemberEventRepository

    fun save (memberEvent: MemberEvent):MemberEvent{
        return memberEventRepository.save(memberEvent)
    }
    fun list ():List<MemberEvent>{
        return memberEventRepository.findAll()
    }

    fun update(memberEvent:MemberEvent):MemberEvent{
        try{
            memberEventRepository.findById(memberEvent.id)
                ?: throw Exception ("El Id no existe")
            return memberEventRepository.save(memberEvent)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(memberEvent:MemberEvent): MemberEvent {
        try{
            val response = memberEventRepository.findById(memberEvent.id)
                ?: throw Exception("ID no existe")
            response.apply {
                assistantId=memberEvent.assistantId
            }
            return memberEventRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}