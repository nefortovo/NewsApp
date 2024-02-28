package com.example.backend.backend.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response<E>(
    @SerialName("status") val status: String,
    @SerialName("totalResults") val totalResults: String,
    @SerialName("articles") val articles: List<E>,
)
