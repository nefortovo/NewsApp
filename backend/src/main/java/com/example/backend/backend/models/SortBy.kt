package com.example.backend.backend.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//relevancy, popularity, publishedAt
@Serializable
enum class SortBy {
    @SerialName("relevancy")
    RELEVANCY,

    @SerialName("popularity")
    POPULARITY,

    @SerialName("publishedAt")
    PUBLISHED_AT
}