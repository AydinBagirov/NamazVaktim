package com.android.namazvaktim.Domain.Repository

import com.android.namazvaktim.Data.Remote.Dto.NamazVaktimDto

interface NamazVaktimRepository {
    suspend fun getNamazVaktim(): NamazVaktimDto
}