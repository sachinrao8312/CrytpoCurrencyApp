package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {

    //For all the coins
    @GET("/v1/coins")
    suspend fun getCoints(): List<CoinDto>

    //For specific coin
    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId")coinId :String) : CoinDetailDto

}
