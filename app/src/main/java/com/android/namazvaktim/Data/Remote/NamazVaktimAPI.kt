package com.android.namazvaktim.Data.Remote

import com.android.namazvaktim.Data.Remote.Dto.NamazVaktimDto
import com.android.namazvaktim.Util.Constants.API_KEY
import com.android.namazvaktim.Util.Constants.CONTENT_TYPE
import retrofit2.http.GET
import retrofit2.http.Header

interface NamazVaktimAPI {
    @GET("pray/all?data.city=istanbul")
    suspend fun getNamazVaktim(
        @Header("content-type") type : String = CONTENT_TYPE,
        @Header("authorization") auth: String = API_KEY
    ): NamazVaktimDto
}
