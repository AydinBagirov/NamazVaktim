package com.android.namazvaktim.DI

import com.android.namazvaktim.Data.Remote.NamazVaktimAPI
import com.android.namazvaktim.Data.Repository.NamazVaktimRepositoryImpl
import com.android.namazvaktim.Domain.Repository.NamazVaktimRepository
import com.android.namazvaktim.Util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): NamazVaktimAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NamazVaktimAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideRepository(namazVaktimAPI: NamazVaktimAPI):NamazVaktimRepository{
        return NamazVaktimRepositoryImpl(namazVaktimAPI)
    }
}