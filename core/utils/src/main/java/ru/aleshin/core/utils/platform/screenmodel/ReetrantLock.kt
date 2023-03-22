/*
 * Copyright 2023 Stanislav Aleshin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package ru.aleshin.core.utils.platform.screenmodel

import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

suspend fun <T> Mutex.withReentrantLock(block: suspend () -> T): T {
    val key = ReentrantMutexContextKey(this)
    if (coroutineContext[key] != null) return block()

    return withContext(ReentrantMutexContextElement(key)) {
        withLock { block() }
    }
}

internal class ReentrantMutexContextElement constructor(
    override val key: ReentrantMutexContextKey,
) : CoroutineContext.Element

internal data class ReentrantMutexContextKey constructor(
    val mutex: Mutex,
) : CoroutineContext.Key<ReentrantMutexContextElement>