package com.example.proyectdg.service

import com.example.evaluacion.model.Assistant
import com.example.evaluacion.repository.AssistantRepository
//import com.example.proyectdg.model.Assistant
//import com.example.proyectdg.repository.AssistantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class AssistantService {
    @Autowired
    lateinit var assistantRepository: AssistantRepository

    fun save (assistant: Assistant):Assistant{
        return assistantRepository.save(assistant)
    }
    fun list ():List<Assistant>{
        return assistantRepository.findAll()
    }

    fun update(assistant:Assistant):Assistant{
        try{
            assistantRepository.findById(assistant.id)
                ?: throw Exception ("El Id no existe")
            return assistantRepository.save(assistant)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(assistant:Assistant): Assistant {
        try{
            val response = assistantRepository.findById(assistant.id)
                ?: throw Exception("ID no existe")
            response.apply {
                cargo=assistant.cargo
            }
            return assistantRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}