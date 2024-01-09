package com.castillo.test.data.network.entities.jikan.anime

import com.castillo.test.logic.usercase.jikan.entities.FullInfoAnimeLG

data class FullInfoAnime(
    val `data`: Data
)
fun FullInfoAnime.getFullAnimeLG() = FullInfoAnimeLG(
    this.data.mal_id,
    this.data.title_english,
    this.data.images.jpg.small_image_url,
    this.data.images.jpg.large_image_url,
    this.data.synopsis
)