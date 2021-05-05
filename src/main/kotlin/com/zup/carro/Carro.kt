package com.zup.carro

import javax.persistence.*
import javax.persistence.GenerationType.*
import javax.validation.constraints.NotBlank

@Entity
class Carro(
    @field:NotBlank
    @Column(nullable = false)
    val modelo: String?,

    @field:NotBlank
    //@field:Placa
    @Column(nullable = false, unique = true)
    val placa: String?
)
{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
}
