package com.android.namazvaktim.Domain.UseCase

import com.android.namazvaktim.Data.Remote.Dto.toNamazVaktim
import com.android.namazvaktim.Domain.Model.NamazVaktimModel
import com.android.namazvaktim.Domain.Repository.NamazVaktimRepository
import com.android.namazvaktim.Util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NamazVaktimUseCase @Inject constructor(
    private val namazVaktimRepository : NamazVaktimRepository) {
    fun getNamazVaktim(): Flow<Resource<List<NamazVaktimModel>>> = flow {
        try {
            emit(Resource.Loading())
            val vaktim = namazVaktimRepository.getNamazVaktim()
            if (vaktim.success == true)
                emit(Resource.Success(vaktim.toNamazVaktim()))
            else
                emit(Resource.Error("NO DATA"))
        }catch (e: HttpException){
            emit(Resource.Error("${e.localizedMessage}"))
        }catch (e:IOException){
            emit(Resource.Error("${e.localizedMessage}"))
        }
    }
}