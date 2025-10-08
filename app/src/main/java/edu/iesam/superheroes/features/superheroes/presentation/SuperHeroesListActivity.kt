package edu.iesam.superheroes.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.superheroes.R
import edu.iesam.superheroes.core.api.ApiClient
import edu.iesam.superheroes.features.superheroes.data.SuperHeroDataRepository
import edu.iesam.superheroes.features.superheroes.data.remote.api.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.ObtainSuperHeroeUseCase
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe
import kotlin.concurrent.thread

class SuperHeroesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //llamada
        //val supeheroes = //
        val superHeroesListViewModel: SuperHeroesListViewModel = SuperHeroesListViewModel(
            ObtainSuperHeroeUseCase(
                SuperHeroDataRepository(
                    SuperHeroesApiRemoteDataSource(
                        ApiClient()
                    )
                ))
        )
        loadSuperHeroes()
    }

    fun printSuperHeroes(superHeroes: List<SuperHeroe>) {
        //función para imprimir los supeheroes en una activity, de momento solo imprime en la terminal
        print(superHeroes)
    }

    private fun loadSuperHeroes(){
        val apiRemote = SuperHeroesApiRemoteDataSource(ApiClient())
        thread {
            val models = apiRemote.getSuperHeroes()
            models
        }
    }
}