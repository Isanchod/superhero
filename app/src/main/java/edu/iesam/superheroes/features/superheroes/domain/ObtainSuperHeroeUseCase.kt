package edu.iesam.superheroes.features.superheroes.domain

class ObtainSuperHeroeUseCase(private val superheroeRepository: SuperheroeRepository) {

    suspend fun invoke() : Result<List<SuperHeroe>> {
        return superheroeRepository.getSuperHeroes()
    }

}