package com.freddydev.ciney.di

import com.freddydev.ciney.util.interceptor.ApiKeyInterceptor
import com.google.gson.Gson
import com.freddydev.ciney.BuildConfig
import com.freddydev.ciney.data.api.services.MovieService
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

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

  @Provides
  @Singleton
  @IntoSet
  fun provideApiKeyInterceptor(): Interceptor {
    return ApiKeyInterceptor(apiKey = BuildConfig.API_KEY)
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
      .baseUrl(BuildConfig.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .build()
  }

  @Provides
  @Singleton
  fun provideMovieService(retrofit: Retrofit): MovieService {
    return retrofit.create(MovieService::class.java)
  }
}