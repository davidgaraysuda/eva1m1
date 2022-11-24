package com.example.proyectdg.controller

import com.example.evaluacion.model.Assistant
//import com.example.proyectdg.model.Assistant
import com.example.proyectdg.service.AssistantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/assistant")

class AssistantController {
    @Autowired
    lateinit var assistantService: AssistantService

    @PostMapping
    fun save (@RequestBody @Valid assistant: Assistant):Assistant{
        return assistantService.save(assistant)
    }

    @GetMapping
    fun list ():List<Assistant>{
        return assistantService.list()
    }

    @PutMapping
    fun update (@RequestBody assistant:Assistant):ResponseEntity<Assistant>{
        return ResponseEntity(assistantService.update(assistant), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody assistant:Assistant): ResponseEntity<Assistant>{
        return ResponseEntity(assistantService.updateName(assistant), HttpStatus.OK)
    }
}