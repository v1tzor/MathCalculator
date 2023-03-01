package ru.aleshin.core.utils.functional

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
sealed class Either<out L, out R> {

    data class Left<L>(val data: L) : Either<L, Nothing>()

    data class Right<R>(val data: R) : Either<Nothing, R>()

    val isLeft = this is Left

    val isRight = this is Right
}
