package com.freddydev.ciney.domain.usecase

abstract class UseCase<out T, in Params> {

  abstract suspend fun execute(params: Params): T

  open class NoParams
}
