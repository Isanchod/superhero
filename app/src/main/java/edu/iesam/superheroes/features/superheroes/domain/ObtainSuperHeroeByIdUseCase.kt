package edu.iesam.superheroes.features.superheroes.domain

class ObtainSuperHeroeByIdUseCase(private val superheroeRepository: SuperheroeRepository) {

    suspend fun invoke(id: String) : Result<SuperHeroe> {
        return superheroeRepository.getSuperHeroesById(id)
    }
}