package edu.iesam.superheroes.features.superheroes.presentation

import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.ObtainSuperHeroeUseCase
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe

class SuperHeroesListViewModel(private val obtainSuperHeroeUseCase: ObtainSuperHeroeUseCase) {
    fun getSuperHeroes(): List<SuperHeroe> {
        val superHeroes = obtainSuperHeroeUseCase.invoke()
        superHeroes.fold(
            {
                superHeroes ->
            },
            {
                errorApp ->
            }

        )
    }
}