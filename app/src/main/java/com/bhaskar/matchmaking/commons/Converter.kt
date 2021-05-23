package com.bhaskar.matchmaking.commons

import io.reactivex.functions.Function

/**
 * Used to Convert One Type to Another
 */
interface Converter<T, R> : Function<T, R>