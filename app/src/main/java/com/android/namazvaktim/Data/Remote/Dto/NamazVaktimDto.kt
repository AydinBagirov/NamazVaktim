package com.android.namazvaktim.Data.Remote.Dto

import com.android.namazvaktim.Domain.Model.NamazVaktimModel

data class NamazVaktimDto(
    val result: List<Result>,
    val success: Boolean
)

fun NamazVaktimDto.toNamazVaktim(): List<NamazVaktimModel> {
    return result.map {
        NamazVaktimModel(
            saat = it.saat,
            vakit = it.vakit
        )
    }
}