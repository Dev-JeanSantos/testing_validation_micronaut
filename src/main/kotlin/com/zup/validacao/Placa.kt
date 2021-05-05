package com.zup.validacao

import javax.validation.Constraint
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CONSTRUCTOR
import kotlin.annotation.AnnotationTarget.FIELD

@MustBeDocumented
@Target(FIELD, CONSTRUCTOR)
@Retention(RUNTIME)
@Constraint(validatedBy = [PlacaValidator::class])
annotation class Placa(
    val message: String = "Placa com formato inválido!"
)

