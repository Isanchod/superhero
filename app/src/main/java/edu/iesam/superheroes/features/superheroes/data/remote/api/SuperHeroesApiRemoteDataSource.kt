package edu.iesam.superheroes.features.superheroes.data.remote.api

import edu.iesam.superheroes.core.api.ApiClient
import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class SuperHeroesApiRemoteDataSource (private val apiClient: ApiClient){
    suspend fun getSuperHeroes(): Result<List<SuperHeroe>> {
        withContext(Dispatchers.IO) {
            val apiService = apiClient.createService(SuperHeroApiService::class.java)
            val resultSuperHero = apiService.findAll().execute()
            if(resultSuperHero.isSuccessful && resultSuperHero.errorBody() == null){
                return Result.success(resultSuperHero.body()!!.map { superHeroApiModel ->
                    superHeroApiModel.toModel()
                })
            } else {
                return Result.failure(ErrorApp.ServerError)
            }
        }
    }
}