package com.rifqipadisiliwangi.latihan_mvp.presenter

import com.rifqipadisiliwangi.latihan_mvp.model.DataCarItem
import com.rifqipadisiliwangi.latihan_mvp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarPresenter (val carView: CarView){

    fun getCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<DataCarItem>>{
                override fun onResponse(
                    call: Call<List<DataCarItem>>,
                    response: Response<List<DataCarItem>>
                ) {
                    if(response.isSuccessful){
                        carView.onSuccess(response.message(), response.body()!!)
                    }
                    else{
                        carView.onFailure(response.message())
                    }

                }

                override fun onFailure(call: Call<List<DataCarItem>>, t: Throwable) {
                    carView.onFailure(t.message!!)
                }

            })
    }

}