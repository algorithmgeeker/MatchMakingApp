package com.bhaskar.matchmaking.network

import com.bhaskar.matchmaking.features.matchmaking.model.DataResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MatchMakingApi {
    @GET(".")
    fun getDataFromApi(@Query("results") resultSize: Int): Single<DataResponse>
}