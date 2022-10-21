package com.rifqipadisiliwangi.latihan_mvp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rifqipadisiliwangi.latihan_mvp.R
import com.rifqipadisiliwangi.latihan_mvp.adapter.CarAdapter
import com.rifqipadisiliwangi.latihan_mvp.databinding.ActivityMainBinding
import com.rifqipadisiliwangi.latihan_mvp.model.DataCarItem
import com.rifqipadisiliwangi.latihan_mvp.presenter.CarPresenter
import com.rifqipadisiliwangi.latihan_mvp.presenter.CarView

class MainActivity : AppCompatActivity(), CarView {
    lateinit var carPresenter: CarPresenter
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carPresenter = CarPresenter(this)
        carPresenter.getCar()
    }

    override fun onSuccess(msg: String, car: List<DataCarItem>) {
        binding.rvMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMain.adapter = CarAdapter(car)
    }

    override fun onFailure(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}