package com.android.namazvaktim.Data.Repository

import com.android.namazvaktim.Data.Remote.Dto.NamazVaktimDto
import com.android.namazvaktim.Data.Remote.NamazVaktimAPI
import com.android.namazvaktim.Domain.Repository.NamazVaktimRepository
import javax.inject.Inject

class NamazVaktimRepositoryImpl @Inject constructor(
    private val namazVaktiApi: NamazVaktimAPI
): NamazVaktimRepository{
    override suspend fun getNamazVaktim(): NamazVaktimDto {
        return namazVaktiApi.getNamazVaktim()
    }
}