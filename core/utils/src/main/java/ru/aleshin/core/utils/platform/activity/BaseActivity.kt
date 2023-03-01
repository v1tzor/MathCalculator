package ru.aleshin.core.utils.platform.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author Stanislav Aleshin on 01.03.2023.
 */
abstract class BaseActivity<VM : ViewModel> : ComponentActivity() {

    protected val viewModel by lazy {
        ViewModelProvider(this, fetchViewModelFactory())[fetchViewModelClass()]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initDI()
        super.onCreate(savedInstanceState)
        setContent { Content() }
    }

    open fun initDI() {}

    @Composable
    abstract fun Content()

    abstract fun fetchViewModelFactory(): ViewModelProvider.Factory

    abstract fun fetchViewModelClass(): Class<VM>
}
