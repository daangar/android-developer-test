package com.dgarcia.parkingapp.ui.base

import android.view.View
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.dgarcia.parkingapp.common.extensions.gone
import com.dgarcia.parkingapp.common.extensions.snackbar
import com.dgarcia.parkingapp.common.extensions.visible

abstract class BaseActivity : AppCompatActivity() {
    fun showError(@StringRes errorMessage: Int, rootView: View) = snackbar(errorMessage, rootView)

    fun showError(errorMessage: String?, rootView: View) = snackbar(errorMessage ?: "", rootView)

    fun showLoading(progressBar: ProgressBar) = progressBar.visible()

    fun hideLoading(progressBar: ProgressBar) = progressBar.gone()
}