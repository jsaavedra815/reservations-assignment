package com.pucetec.reservations.services

import com.pucetec.reservations.models.entities.Professor
import com.pucetec.reservations.models.entities.Subject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubjectServiceTest {

    @Test
    fun `should return correct subject name`() {
        val professor: Professor = Professor(
            name = "Jorge",
            department = "Sistemas"
        )
        val subject = Subject(name = "Arquitectura Empresarial",
            semester = "2023-2",
            professor = professor,
            students = mutableSetOf()
        )
        assertEquals("Arquitectura Empresarial", subject.name)
    }

    @Test
    fun `should return correct subject semester`() {
        val professor: Professor = Professor(
            name = "Jorge",
            department = "Sistemas"
        )
        val subject = Subject(name = "Arquitectura Empresarial",
            semester = "2023-2",
            professor = professor,
            students = mutableSetOf()
        )
        assertEquals("2023-2", subject.semester)
    }
}