package com.zup.carro

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid

@Controller
@Validated
class CarroController(
    @Inject val carroRepository: CarroRepository
) {

        @Post("/api/carros")
        fun criar(@Body @Valid carro: Carro): HttpResponse<Any> {
            val carroSalvo = carroRepository.save(carro)
            return HttpResponse.ok(carroSalvo)
        }
}