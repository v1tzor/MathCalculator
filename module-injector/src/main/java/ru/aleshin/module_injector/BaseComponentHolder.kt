package ru.aleshin.module_injector

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
interface BaseComponentHolder<A : BaseFeatureApi, D : BaseFeatureDependencies> {

    /**
     * Initializes the internal DI graph to be able to get the API features.
     *
     * @param dependencies needed for the features to work
     */
    fun init(dependencies: D)

    /**
     * Allows get API for this features if DI graph is initialize.
     *
     * @return [A] API for working with features
     *
     * @exception IllegalStateException if DI graph is not initialized.
     */
    fun fetchApi(): A

    /**
     * Deleting the internal DI graph to close feature.
     */
    fun clear()
}
