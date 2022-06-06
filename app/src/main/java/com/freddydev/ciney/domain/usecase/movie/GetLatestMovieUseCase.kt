package com.freddydev.ciney.domain.usecase.movie

import com.freddydev.ciney.domain.model.movie.MovieDetail
import com.freddydev.ciney.domain.repository.MovieRepository
import com.freddydev.ciney.domain.usecase.UseCase
import com.freddydev.ciney.util.Resource
import javax.inject.Inject

class GetLatestMovieUseCase @Inject constructor(private val movieRepos: MovieRepository) :
  UseCase<MovieDetail, UseCase.NoParams>() {

  suspend fun execute(): Resource<MovieDetail> {
    return movieRepos.getLatestMovie()
  }
}