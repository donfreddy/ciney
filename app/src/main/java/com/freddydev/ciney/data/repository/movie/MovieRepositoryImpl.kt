package com.freddydev.ciney.data.repository.movie

import androidx.annotation.WorkerThread
import com.freddydev.ciney.data.dto.movie.toMovieDetail
import com.freddydev.ciney.data.dto.movie.toMovies
import com.freddydev.ciney.data.repository.movie.datasource.MovieLocalDatasource
import com.freddydev.ciney.data.repository.movie.datasource.MovieRemoteDatasource
import com.freddydev.ciney.domain.model.movie.Movie
import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.domain.model.movie.Movies
import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.util.Constants.HTTP_EXCEPT_MSG
import com.freddydev.ciney.util.Constants.IO_EXCEPT_MSG
import com.freddydev.ciney.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

/**
 * This class is a implementation of [MovieRepository]
 */
class MovieRepositoryImpl constructor(
  private val movieRemoteDatasource: MovieRemoteDatasource,
  private val movieLocalDataSource: MovieLocalDatasource,
) : MovieRepository {

  @WorkerThread
  override fun getMovies(category: String, page: Int): Flow<Resource<List<Movie>>> = flow {
    try {
      emit(Resource.Loading())
      val responseBody = movieRemoteDatasource.getMovies(category, page).body()
      if (responseBody != null) {
        val movies: List<Movie> = responseBody.toMovies().movies

        // Todo: Save movies in local database

        emit(Resource.Success(movies))
      }
    } catch (e: HttpException) {
      emit(Resource.Error(message = HTTP_EXCEPT_MSG))
    } catch (e: IOException) {
      /**
       * Todo: Get data from [movieLocalDataSource] if no connexion.
       */
      emit(Resource.Error(message = IO_EXCEPT_MSG))
    }
  }
}