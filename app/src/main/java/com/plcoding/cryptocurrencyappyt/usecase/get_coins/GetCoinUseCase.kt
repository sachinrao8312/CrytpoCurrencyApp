package com.plcoding.cryptocurrencyappyt.usecase.get_coins

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())

            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        }
        catch (e : HttpException){
            emit( Resource.Error(e.localizedMessage ?: "An Unexpected Error")
            )
        }
        catch (e : IOException){
           emit(Resource.Error(e.localizedMessage ?: "Can't Reach Server . Check Your Internet"))
        }
    }
}