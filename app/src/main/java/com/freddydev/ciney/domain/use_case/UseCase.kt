package com.freddydev.ciney.domain.use_case

/**
 * This abstract class is a base class for all use cases.
 * It provides a way to execute use cases with parameters or without parameters.
 * @param [T] the type of the use case result.
 * @param [Params] the type of the use case parameters.
 * @author Don Freddy
 */
abstract class UseCase<out T, in Params> {

  open class NoParams
}
