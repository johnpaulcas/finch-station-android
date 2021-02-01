package com.finchstation.android.di

import android.app.Application
import androidx.room.Room
import com.finchstation.android.AppConstant
import com.finchstation.android.AppExecutors
import com.finchstation.android.BuildConfig
import com.finchstation.android.api.finchstation.FinchStationService
import com.finchstation.android.db.FinchStationDb
import com.finchstation.android.db.dao.FinchStationDao
import com.finchstation.android.db.dao.FinchStationRouteDao
import com.finchstation.android.db.dao.FinchStationRouteStopTimeDao
import com.finchstation.android.db.dao.FinchStationStopDao
import com.finchstation.android.db.entities.FinchStation
import com.finchstation.android.helpers.LiveDataCallAdapterFactory
import com.finchstation.android.repository.finchstation.FinchStationRepository
import com.finchstation.android.repository.finchstation.FinchStationRepositoryImpl
import com.finchstation.android.repository.routeStopTimes.RouteStopTimesRepository
import com.finchstation.android.repository.routeStopTimes.RouteStopTimesRepositoryImpl
import com.finchstation.android.repository.routes.RoutesRepository
import com.finchstation.android.repository.routes.RoutesRepositoryImpl
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

    // retrofit

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
    fun provideFinchStationService(okHttpClient: OkHttpClient): FinchStationService {
        return Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .client((okHttpClient))
                .build()
                .create(FinchStationService::class.java)
    }

    // database

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

    // repositories

    @Singleton
    @Provides
    fun provideFinchStationRepository(
            apiExecutors: AppExecutors,
            finchStationService: FinchStationService,
            finchStationDao: FinchStationDao,
            finchStationStopDao: FinchStationStopDao,
            finchStationRouteDao: FinchStationRouteDao,
            finchStationRouteStopTimeDao: FinchStationRouteStopTimeDao
    ): FinchStationRepository {
        return FinchStationRepositoryImpl(
                apiExecutors,
                finchStationService,
                finchStationDao,
                finchStationStopDao,
                finchStationRouteDao,
                finchStationRouteStopTimeDao
        )
    }

    @Singleton
    @Provides
    fun provideRoutesRepository(
        finchStationStopDao: FinchStationStopDao
    ): RoutesRepository {
        return RoutesRepositoryImpl(finchStationStopDao)
    }

    @Singleton
    @Provides
    fun provideRouteStopTimesRepository(
        finchStationRouteDao: FinchStationRouteDao
    ): RouteStopTimesRepository {
        return RouteStopTimesRepositoryImpl(finchStationRouteDao)
    }

}