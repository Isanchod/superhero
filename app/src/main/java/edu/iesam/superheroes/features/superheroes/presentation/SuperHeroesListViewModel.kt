package edu.iesam.superheroes.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.superheroes.features.superheroes.domain.ObtainSuperHeroeByIdUseCase
import edu.iesam.superheroes.features.superheroes.domain.ObtainSuperHeroeUseCase
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import kotlinx.coroutines.launch

class SuperHeroesListViewModel(
    private val obtainSuperHeroeUseCase: ObtainSuperHeroeUseCase,
    private val obtainSuperHeroeByIdUseCase: ObtainSuperHeroeByIdUseCase
) : ViewModel() {

    fun loadSuperHeroes() {
        viewModelScope.launch {
            val superHeroes = obtainSuperHeroeUseCase.invoke()
        }
    }

    fun loadSuperHeroesById(id: String) {
        viewModelScope.launch {
            val superHeroes = obtainSuperHeroeByIdUseCase.invoke(id)
            print(superHeroes)
        }
    }


}