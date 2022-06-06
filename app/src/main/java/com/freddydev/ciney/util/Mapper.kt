package com.freddydev.ciney.util

interface Mapper<Input, Output> {
    fun map(input: Input): Output
}
