package com.example.gamestache.api

import com.example.gamestache.models.TwitchAuthorization
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface TwitchApiAuth {

    @POST("oauth2/token")
    suspend fun getAccessToken(
        @Query("client_id") client_id: String,
        @Query("client_secret") client_secret: String,
        @Query("grant_type") grant_type: String
    ): Response<TwitchAuthorization>

}