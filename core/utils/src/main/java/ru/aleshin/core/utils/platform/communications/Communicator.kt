package ru.aleshin.core.utils.platform.communications

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface Communicator<T> {

    suspend fun collect(collector: FlowCollector<T>)

    suspend fun read(): T

    fun update(data: T)

    abstract class AbstractStateFlow<T>(defaultValue: T) : Communicator<T> {

        private val flow = MutableStateFlow(value = defaultValue)

        override suspend fun collect(collector: FlowCollector<T>) {
            flow.collect(collector)
        }

        override suspend fun read(): T {
            return flow.value
        }

        override fun update(data: T) {
            flow.tryEmit(data)
        }
    }

    abstract class AbstractSharedFlow<T>(
        flowReplay: Int = 0,
        flowBufferCapacity: Int = 0,
        flowBufferOverflow: BufferOverflow = BufferOverflow.SUSPEND,
    ) : Communicator<T> {

        private val flow = MutableSharedFlow<T>(
            replay = flowReplay,
            extraBufferCapacity = flowBufferCapacity,
            onBufferOverflow = flowBufferOverflow,
        )

        override suspend fun collect(collector: FlowCollector<T>) {
            flow.collect(collector)
        }

        override suspend fun read(): T {
            return flow.first()
        }

        override fun update(data: T) {
            flow.tryEmit(data)
        }
    }
}
