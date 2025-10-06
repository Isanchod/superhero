package edu.iesam.superheroes.features.superheroes.presentation

import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.ObtainSuperHeroeUseCase
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe

class SuperHeroesListViewModel(private val obtainSuperHeroeUseCase: ObtainSuperHeroeUseCase) {
    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        return obtainSuperHeroeUseCase.invoke()

    }
}