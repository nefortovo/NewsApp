package com.example.backend.backend.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * * -"source": {
 *  * "id": "engadget",
 *  * "name": "Engadget"
 *  * },
 */
@Serializable
data class Source (
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
)
