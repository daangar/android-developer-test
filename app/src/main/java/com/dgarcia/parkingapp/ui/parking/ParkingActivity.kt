package com.dgarcia.parkingapp.ui.parking

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dgarcia.parkingapp.R
import com.dgarcia.parkingapp.databinding.ActivityParkingBinding
import com.dgarcia.parkingapp.ui.base.BaseActivity
import com.dgarcia.parkingapp.ui.car.CarActivity
import kotlinx.android.synthetic.main.activity_parking.*

class ParkingActivity: BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityParkingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddCar.setOnClickListener {
            val intent = Intent(this, CarActivity::class.java)
            startActivity(intent)
        }

        binding.btnReiniciar.setOnClickListener {

        }

        binding.btnEntrada.setOnClickListener {

        }

        binding.btnSalida.setOnClickListener {

        }

    }
}
