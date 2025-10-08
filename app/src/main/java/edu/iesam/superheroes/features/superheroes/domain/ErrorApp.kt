package edu.iesam.superheroes.features.superheroes.domain

sealed class ErrorApp : Throwable(){
    object ApiError : ErrorApp()
    object ServerError : ErrorApp()
}