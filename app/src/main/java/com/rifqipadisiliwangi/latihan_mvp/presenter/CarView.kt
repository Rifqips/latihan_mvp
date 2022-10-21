package com.rifqipadisiliwangi.latihan_mvp.presenter

import com.rifqipadisiliwangi.latihan_mvp.model.DataCarItem

interface CarView {
    fun onSuccess(msg : String, car : List<DataCarItem>)
    fun onFailure(msg : String)
}