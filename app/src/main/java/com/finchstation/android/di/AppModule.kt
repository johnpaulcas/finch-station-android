package com.finchstation.android.di

import android.app.Application
import androidx.room.Room
import com.finchstation.android.BuildConfig
import com.finchstation.android.api.finchstation.FinchStationService
import com.finchstation.android.db.FinchStationDb
import com.finchstation.android.db.dao.FinchStationDao
import com.finchstation.android.db.dao.FinchStationRouteDao
import com.finchstation.android.db.dao.FinchStationRouteStopTimeDao
import com.finchstation.android.db.dao.FinchStationStopDao
import com.finchstation.android.helpers.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author johnpaulcas
 * @since 30/01/2021
 */
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(200, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            // log request for debugging
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }

        return okHttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideFinchStationService(okHttpClient: OkHttpClient, baseUrl: String): FinchStationService {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .client((okHttpClient))
                .build()
                .create(FinchStationService::class.java)
    }

    @Singleton
    @Provides
    fun provideFinchStationDb(
            app: Application
    ) = Room.databaseBuilder(app, FinchStationDb::class.java, "finchstation_database")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideFinchStationDao(db: FinchStationDb): FinchStationDao {
        return db.finchStationDao()
    }

    @Singleton
    @Provides
    fun provideFinchStationStopDao(db: FinchStationDb): FinchStationStopDao {
        return db.finchStationStopDao()
    }

    @Singleton
    @Provides
    fun provideFinchStationRouteDao(db: FinchStationDb): FinchStationRouteDao {
        return db.finchStationRouteDao()
    }

    @Singleton
    @Provides
    fun provideFinchStationRouteStopTime(db: FinchStationDb): FinchStationRouteStopTimeDao {
        return db.finchStationRouteStopTimeDao()
    }
}