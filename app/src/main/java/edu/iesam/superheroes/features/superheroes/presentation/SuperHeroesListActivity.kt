package edu.iesam.superheroes.features.superheroes.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.superheroes.R
import edu.iesam.superheroes.features.superheroes.data.SuperheroeDataRepository
import edu.iesam.superheroes.features.superheroes.data.local.SuperHeroesFileLocalDataSource
import edu.iesam.superheroes.features.superheroes.data.remote.SuperHeroesApiRemoteDataSource
import edu.iesam.superheroes.features.superheroes.domain.ObtainSuperHeroeUseCase

class SuperHeroesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            //llamada
            //val supeheroes = //

            val superHeroesListViewModel = SuperHeroesListViewModel(
                ObtainSuperHeroeUseCase(
                    SuperheroeDataRepository(
                        SuperHeroesApiRemoteDataSource(),
                        SuperHeroesFileLocalDataSource()
                    )
                )
            )
        }
    }
}