package edu.iesam.superheroes.core.api

import edu.iesam.superheroes.features.superheroes.data.remote.api.SuperHeroApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val BASE_URL = ""

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(typeClass: Class<T>) : T{
        return retrofit.create(typeClass)
    }

    fun createSuperHero(superHero: SuperHeroApiModel) {

    }
}