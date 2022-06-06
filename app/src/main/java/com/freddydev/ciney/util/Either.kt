package com.freddydev.ciney.util

/**
 * Either is a type-safe alternative to the Either type from the Haskell Prelude.
 * It is a data type that represents a value that is either a Left or a Right.
 * @param <F> The type of the Left value.
 * @param <S> The type of the Right value.
 */

sealed class Either<out F, out S>

data class Failure<out F>(val failure: F) : Either<F, Nothing>()

data class Success<out S>(val success: S) : Either<Nothing, S>()