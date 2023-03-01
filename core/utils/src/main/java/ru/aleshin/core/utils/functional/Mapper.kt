package ru.aleshin.core.utils.functional

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface Mapper<I, O> {
    fun map(input: I): O
}
