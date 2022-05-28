package com.freddydev.ciney.di

import com.freddydev.ciney.service.CineyService
import com.freddydev.ciney.util.interceptor.ApiKeyInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.themoviedb.org/3"

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Provides
  @Singleton
  @IntoSet
  fun provideApiKeyInterceptor(): Interceptor {
    return ApiKeyInterceptor(apiKey = "b838b78e9e0e25b39e41a2d3b197a08f")
  }

  @Provides
  @Singleton
  fun provideGson(): Gson {
    return GsonBuilder().setLenient().create()
  }

  @Provides
  @Singleton
  fun provideOkHttpClient(interceptors: Set<@JvmSuppressWildcards Interceptor>): OkHttpClient {
    // add logging interceptor
    val logging = HttpLoggingInterceptor()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient.Builder().apply {
      addInterceptor(logging).interceptors().addAll(interceptors)
    }.build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .build()
  }

  @Provides
  @Singleton
  fun provideCineyService(retrofit: Retrofit): CineyService {
    return retrofit.create(CineyService::class.java)
  }
}