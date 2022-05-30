package com.freddydev.ciney.data.api

sealed class ApiResult<T> {
  data class Success<T>(val data: T) : ApiResult<T>()
  data class Error<T>(val throwable: Throwable) : ApiResult<T>()

  fun onSuccess(block: (T) -> Unit): ApiResult<T> {
    if (this is Success<T>) {
      block.invoke(data)
    }
    return this
  }

  fun onError(block: (Throwable) -> Unit): ApiResult<T> {
    if (this is Error<T>) {
      block.invoke(throwable)
    }
    return this
  }
}