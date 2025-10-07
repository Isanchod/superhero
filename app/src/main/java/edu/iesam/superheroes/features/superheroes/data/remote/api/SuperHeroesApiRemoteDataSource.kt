package edu.iesam.superheroes.features.superheroes.data.remote.api

import edu.iesam.superheroes.core.api.ApiClient
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe

class SuperHeroesApiRemoteDataSource {
    fun getSuperHeroes(): Result<List<SuperHeroe>> {
        val apiService = ApiClient.createService(SuperHeroApiService::class.java)
        apiService.findAll()
        return Result.success(listOf())
    }
}