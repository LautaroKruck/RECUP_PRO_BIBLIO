package org.example
import java.util.UUID

class UtilidadesBiblioteca {
    companion object {
        fun generarIdentificadorUnico(): String = UUID.randomUUID().toString()
    }
}