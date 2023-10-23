package com.plcoding.cryptocurrencyappyt.usecase.get_coin

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinDetail
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinDetailsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> =  flow{
        try {
            emit(Resource.Loading())

            val coinDetails = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coinDetails))

        }
        catch (e : HttpException)
        {
            emit(Resource.Error(e.localizedMessage ?: "An Unexpected Error"))
        }
        catch (e : IOException)
        {
            emit(Resource.Error(e.localizedMessage ?:"Can't reach Server . Check Internet Connection"))
        }
    }

}