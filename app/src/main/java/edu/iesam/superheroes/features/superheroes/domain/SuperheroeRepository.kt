package edu.iesam.superheroes.features.superheroes.domain

interface SuperheroeRepository {
    fun getSuperHeroes():Result<List<SuperHeroe>>
}