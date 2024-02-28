package com.example.backend.backend.api

import androidx.annotation.IntRange
import com.example.backend.backend.models.Article
import com.example.backend.backend.models.Languages
import com.example.backend.backend.models.Response
import com.example.backend.backend.models.SortBy
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import java.util.Date

interface NewsApi {
    @GET("/everything")
    suspend fun everything(
        @Query("q") query: String? = null,
        @Query("from") from: Date? = null,
        @Query("to") to: Date? = null,
        @Query("language") language: Array<Languages>? = null,
        @Query("sortBy") sortBy: SortBy? = null,
        @Query("pageSize") @IntRange(from = 0, to = 100) pageSize: Int = 100,
        @Query("page") @IntRange(from = 1) page: Int = 1,
    ): Response<Article>
}



