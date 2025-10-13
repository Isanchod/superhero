package edu.iesam.superheroes.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.ObtainSuperHeroeByIdUseCase
import edu.iesam.superheroes.features.superheroes.domain.ObtainSuperHeroeUseCase
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import kotlinx.coroutines.launch

class SuperHeroesListViewModel(
    private val obtainSuperHeroeUseCase: ObtainSuperHeroeUseCase,
    private val obtainSuperHeroeByIdUseCase: ObtainSuperHeroeByIdUseCase
) : ViewModel() {

        private val _uiState = MutableLiveData<UiState>()
        val uiState : LiveData<UiState> = _uiState

    fun loadSuperHeroes() {
        viewModelScope.launch {
            _uiState.value = UiState(isLoading = true)
            obtainSuperHeroeUseCase.invoke().fold(
                {loadOnSuccess(it)},
                {loadOnFailure(it as ErrorApp)})
        }
    }

    fun loadOnSuccess(superHeroes: List<SuperHeroe>){
        _uiState.value = UiState(superHeroes = superHeroes)
    }

    fun loadOnFailure(errorApp: ErrorApp){

    }


    fun loadSuperHeroesById(id: String) {
        viewModelScope.launch {
            val superHeroes = obtainSuperHeroeByIdUseCase.invoke(id)
            print(superHeroes)
        }
    }

    fun loadByIdOnSuccess(superHeroe: SuperHeroe) {

    }

    fun loadByIdOnFailure(errorApp: ErrorApp) {

    }

    data class UiState(
        val error: ErrorApp? = null,
        val isLoading: Boolean = false,
        val superHeroes: List<SuperHeroe>? = null
    )
}