package edu.iesam.superheroes.features.superheroes.data

import edu.iesam.superheroes.features.superheroes.data.local.SuperHeroesFileLocalDataSource
import edu.iesam.superheroes.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import edu.iesam.superheroes.features.superheroes.domain.SuperheroeRepository

class SuperheroeDataRepository(
    private val superHeroesApiRemoteDataSource: SuperHeroesApiRemoteDataSource,
    private val superHeroesFileLocalDataSource: SuperHeroesFileLocalDataSource
) : SuperheroeRepository {

    override fun getSuperHeroes(): List<SuperHeroe> {
        var superheroes = superHeroesApiRemoteDataSource.getSuperHeroes()
        superheroes.fold(
            {
                superheroes -> return superheroes
            },
            {
                return superHeroesFileLocalDataSource.getSuperHeroes()
            }
        )
    }
}