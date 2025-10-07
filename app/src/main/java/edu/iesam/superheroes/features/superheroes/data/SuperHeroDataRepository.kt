package edu.iesam.superheroes.features.superheroes.data

import edu.iesam.superheroes.features.superheroes.data.remote.api.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import edu.iesam.superheroes.features.superheroes.domain.SuperheroeRepository

class SuperHeroDataRepository(
    private val superHeroesApiRemoteDataSource: SuperHeroesApiRemoteDataSource,
) : SuperheroeRepository {

    override fun getSuperHeroes(): Result<List<SuperHeroe>> {
        return superHeroesApiRemoteDataSource.getSuperHeroes()
    }
}