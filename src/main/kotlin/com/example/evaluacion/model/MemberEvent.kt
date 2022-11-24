package com.example.evaluacion.model

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name="member_event")

class MemberEvent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name="assistant_id")
    @NotNull
    var assistantId: Long?=null
    @Column(name="conference_id")
    @NotNull
    var conferenceId: Long?=null

}