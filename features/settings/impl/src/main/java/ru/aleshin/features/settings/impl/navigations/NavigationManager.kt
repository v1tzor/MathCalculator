package ru.aleshin.features.settings.impl.navigations

import ru.aleshin.core.utils.navigations.Router
import javax.inject.Inject

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
internal interface NavigationManager {

    fun showPreviousFeature()

    class Base @Inject constructor(private val globalRouter: Router) : NavigationManager {
        override fun showPreviousFeature() {
            globalRouter.navigateBack()
        }
    }
}