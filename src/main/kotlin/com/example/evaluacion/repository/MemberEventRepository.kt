package com.example.evaluacion.repository

import com.example.evaluacion.model.MemberEvent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface MemberEventRepository:JpaRepository<MemberEvent, Long?> {
    fun findById(id:Long?):MemberEvent?
}