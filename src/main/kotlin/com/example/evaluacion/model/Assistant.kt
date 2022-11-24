package com.example.evaluacion.model

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name="assistant")

class Assistant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotNull
    @NotBlank
    var nombres: String? = null
    @NotNull
    var email: String?=null
    @NotNull
    var institucion: String?=null
    @NotNull
    var cargo: String?=null
}