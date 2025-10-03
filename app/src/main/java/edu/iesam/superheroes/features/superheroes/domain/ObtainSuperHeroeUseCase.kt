package edu.iesam.superheroes.features.superheroes.domain

class ObtainSuperHeroeUseCase(private val superheroeRepository: SuperheroeRepository) {

    fun invoke() : Result<List<SuperHeroe>> {
        return superheroeRepository.getSuperHeroes()
    }

}