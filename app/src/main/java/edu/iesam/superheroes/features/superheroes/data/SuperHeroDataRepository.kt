package edu.iesam.superheroes.features.superheroes.data

import edu.iesam.superheroes.features.superheroes.data.remote.api.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import edu.iesam.superheroes.features.superheroes.domain.SuperheroeRepository

class SuperHeroDataRepository(
    private val superHeroesApiRemoteDataSource: SuperHeroesApiRemoteDataSource,
) : SuperheroeRepository {

    override suspend fun getSuperHeroes(): Result<List<SuperHeroe>> {
        return superHeroesApiRemoteDataSource.getSuperHeroes()
    }

    override suspend fun getSuperHeroesById(id: String): Result<SuperHeroe> {
        return superHeroesApiRemoteDataSource.getSuperHeroesById(id)
    }
}