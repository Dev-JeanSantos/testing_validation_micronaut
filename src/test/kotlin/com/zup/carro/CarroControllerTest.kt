package com.zup.carro

import io.micronaut.test.annotation.TransactionMode
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest(
    rollback = false,
    transactionMode = TransactionMode.SINGLE_TRANSACTION,
    transactional = true
)

internal class CarroControllerTest{

    @Inject
    lateinit var carroRepository: CarroRepository

    @BeforeEach
    fun setup(){
        carroRepository.deleteAll()
    }

    @AfterEach
    fun clean(){
        carroRepository.deleteAll()
    }

    @Test
    internal fun `deve inserir um novo carro`() {

        //ação
        carroRepository.save(Carro("FIAT IDEA", "KNK2033"))

        //validação
        assertEquals(1, carroRepository.count())

    }

    @Test
    internal fun `deve encontrar o carro pela placa`() {
        //cenário
        carroRepository.save(Carro("FIAT IDEA", "KMK3322"))
        //ação
        val existeCarro = carroRepository.existsByPlaca("KMK3322")
        //validação
        assertTrue(existeCarro)    }
}