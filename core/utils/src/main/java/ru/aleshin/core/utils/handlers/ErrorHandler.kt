package ru.aleshin.core.utils.handlers

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface ErrorHandler<E> {
    fun handle(throwable: Throwable): E
}
