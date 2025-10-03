package edu.iesam.superheroes.features.superheroes.data

import edu.iesam.superheroes.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import edu.iesam.superheroes.features.superheroes.domain.SuperheroeRepository

class SuperheroeDataRepository(
    private val superHeroesApiRemoteDataSource: SuperHeroesApiRemoteDataSource,
) : SuperheroeRepository {

    override fun getSuperHeroes(): Result<List<SuperHeroe>> {
        return superHeroesApiRemoteDataSource.getSuperHeroes()
    }
}