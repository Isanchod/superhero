package edu.iesam.superheroes.features.superheroes.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.superheroes.R
import edu.iesam.superheroes.features.superheroes.data.SuperheroeDataRepository
import edu.iesam.superheroes.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.ErrorApp
import edu.iesam.superheroes.features.superheroes.domain.ObtainSuperHeroeUseCase
import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe

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
                SuperheroeDataRepository(
                    SuperHeroesApiRemoteDataSource()
                ))
        )
        val superHeroes = superHeroesListViewModel.getSuperHeroes()
    }

    fun getSuperHeroes(superHeroesListViewModel : SuperHeroesListViewModel){
        val superHeroes = superHeroesListViewModel.getSuperHeroes()
        superHeroes.fold(
            {
                superHeroes -> printSuperHeroes(superHeroes)
            },
            {
                errorApp -> getSuperHeroesOnFailure(errorApp as ErrorApp)
            }
        )

    }

    fun printSuperHeroes(superHeroes: List<SuperHeroe>) {
        //función para imprimir los supeheroes en una activity, de momento solo imprime en la terminal
        print(superHeroes)
    }

    fun getSuperHeroesOnFailure(errorApp: ErrorApp) {
        when(errorApp){
            ErrorApp.ApiError -> {print("Ha ocurrido un error al recuperar los superhéroes")}
        }
    }
}