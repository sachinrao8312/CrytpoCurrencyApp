package com.plcoding.cryptocurrencyappyt.domain.model


import com.plcoding.cryptocurrencyappyt.data.remote.dto.TeamMember

data class CoinDetail(
    val description: String,
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val team: List<TeamMember>,
    val tags: List<String>
)

