package com.example.projviewbindingpoc.data.repository

import com.example.projviewbindingpoc.business.repository.QuestionRepository
import com.example.projviewbindingpoc.data.models.Question
import java.util.*

class QuestionRepositoryImpl : QuestionRepository {
    override fun getQuestions(): List<Question> {
        return listOf(
            Question(
                UUID.randomUUID().toString(),
                "Em que ano e onde aconteceu o maior acidente aéreo da história do Brasil?",
                listOf(
                    "Ano 2007, em São Paulo",
                    "Ano 2006, no Mato Grosso",
                    "Ano 1982, no Ceará",
                    "Ano 1996, em São Paulo",
                    "Ano 1952, na Floresta Amazônica"
                ),
                0
            ),
            Question(
                UUID.randomUUID().toString(),
                "Quais os quatros países que têm a maior população carcerária do mundo?",
                listOf(
                    "Brasil, Estados Unidos, México e Índia",
                    "China, Estados Unidos, Índia e Indonésia",
                    "Rússia, Japão, Canadá e China",
                    "Estados Unidos, China, Rússia e Brasil",
                    "Brasil, Estados Unidos, China e Vaticano"
                ),
                3
            ),
            Question(
                UUID.randomUUID().toString(),
                "Qual foi a revolução que alavancou a independência do Brasil e em 2017 completou o segundo centenário?",
                listOf(
                    "Revolução Farroupilha",
                    "Revolução Federalista",
                    "Revolução Praieira",
                    "Revolução Pernambucana",
                    "Revolução Acreana"
                ),
                3
            )
        )
    }
}