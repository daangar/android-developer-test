package com.dgarcia.parkingapp.ui.car


import android.os.Bundle
import android.widget.ArrayAdapter
import com.dgarcia.domain.model.Car
import com.dgarcia.domain.model.CarType
import com.dgarcia.parkingapp.R
import com.dgarcia.parkingapp.common.extensions.hideKeyboard
import com.dgarcia.parkingapp.common.extensions.snackbar
import com.dgarcia.parkingapp.common.extensions.subscribe
import com.dgarcia.parkingapp.databinding.ActivityCarBinding
import com.dgarcia.parkingapp.model.CarApp
import com.dgarcia.parkingapp.ui.base.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class CarActivity : BaseActivity() {

    private lateinit var binding: ActivityCarBinding
    private val viewModel: CarViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        suscribeToData()

        setupUI()
    }

    private fun setupUI() {

        //region listeners
        binding.btnRegistrarCarro.setOnClickListener {
            it.hideKeyboard()
            val plate = binding.etPlaca.text.toString()
            val type = binding.spnCarType.selectedItem.toString()

            if (plate.isEmpty()) {
                handleError("Debe ingresar el número de placa")
                return@setOnClickListener
            }

            val car = CarApp(plate, CarType.valueOf(type.toUpperCase(Locale.ROOT)))
            viewModel.registerCar(car)
        }
        //endregion

        //region spinner
        val types = CarType.values().toList()
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, types)
        binding.spnCarType.adapter = spinnerAdapter
        //endregion
    }

    private fun suscribeToData() {
        viewModel.viewState.subscribe(this, ::handleViewState)
    }


    private fun handleViewState(viewState: ViewState<Car>) {
        when (viewState) {
            is Loading -> showLoading(binding.loadingProgress)
            is Success -> close()
            is Error -> handleError(viewState.error.localizedMessage)
            is NoInternetState -> showNoInternetError()
        }
    }

    private fun handleError(error: String) {
        hideLoading(binding.loadingProgress)
        showError(error, binding.container)
    }

    private fun showNoInternetError() {
        hideLoading(binding.loadingProgress)
        snackbar(getString(R.string.no_internet_error_message), binding.container)
    }

    private fun close() {
        hideLoading(binding.loadingProgress)
        GlobalScope.launch(Dispatchers.Main) {
            delay(2000)
            finish()
        }
        snackbar("Vehículo registrado", binding.container)

    }


}
