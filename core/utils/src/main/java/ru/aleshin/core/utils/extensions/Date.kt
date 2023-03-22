package ru.aleshin.core.utils.extensions

import java.util.*

/**
 * @author Stanislav Aleshin on 22.03.2023.
 */
fun Long.mapToDate(): Date {
    val calendar = Calendar.getInstance().also {
        it.timeInMillis = this
    }
    return calendar.time
}

fun Date.isCurrentDay(): Boolean {
    val currentDate = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
    val compareDate = Calendar.getInstance().apply {
        time = this@isCurrentDay
    }.get(Calendar.DAY_OF_MONTH)

    return currentDate == compareDate
}

fun Date.startThisDay(): Date {
    val calendar = Calendar.getInstance()
    calendar.time = this
    return calendar.setStartDay().time
}

fun Date.endThisDay(): Date {
    val calendar = Calendar.getInstance()
    calendar.time = this
    return calendar.setEndDay().time
}

fun Calendar.setStartDay() = this.apply {
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.MINUTE, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MILLISECOND, 0)
}

fun Calendar.setEndDay() = this.apply {
    set(Calendar.HOUR_OF_DAY, 23)
    set(Calendar.MINUTE, 59)
    set(Calendar.SECOND, 59)
    set(Calendar.MILLISECOND, 59)
}