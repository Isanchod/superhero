package edu.iesam.superheroes.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.superheroes.features.superheroes.domain.ObtainSuperHeroeUseCase
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import kotlinx.coroutines.launch

class SuperHeroesListViewModel(private val obtainSuperHeroeUseCase: ObtainSuperHeroeUseCase):
    ViewModel() {

        fun loadSuperHeroes() {
            viewModelScope.launch {
                val superHeroes = obtainSuperHeroeUseCase.invoke()
            }
        }
}