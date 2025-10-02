package edu.iesam.superheroes.features.superheroes.data.local

import edu.iesam.superheroes.features.superheroes.domain.SuperHeroe

class SuperHeroesFileLocalDataSource {
    fun getSuperHeroes() : List<SuperHeroe> {
        val superHeroes = listOf<SuperHeroe>(
            SuperHeroe("0001", "Bruce Wayne", "Batman", "https://preview.redd.it/what-do-you-prefer-in-comics-batman-portrayed-in-a-more-v0-cfd0vq1jhcie1.jpg?width=449&format=pjpg&auto=webp&s=610d008ff05e4dbb7486bb8fe15dc7f38615cd21"),
            SuperHeroe("0002", "Peter Parker", "Spìderman", "https://preview.redd.it/how-would-you-want-a-new-spider-man-show-to-happen-v0-ij8i3gjdicoe1.jpeg?auto=webp&s=86e21f68ceaea7dc0f9e4678cf855f2676dfcc96")
        )
        return superHeroes
    }
}