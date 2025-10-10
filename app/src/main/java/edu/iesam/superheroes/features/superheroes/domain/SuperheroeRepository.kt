package edu.iesam.superheroes.features.superheroes.domain

interface SuperheroeRepository {
    suspend fun getSuperHeroes():Result<List<SuperHeroe>>
    suspend fun getSuperHeroesById(id: String):Result<SuperHeroe>
}