package ch12

fun <T> T?.orThrow(exceptionLambda: () -> Throwable) = this ?: throw exceptionLambda()
