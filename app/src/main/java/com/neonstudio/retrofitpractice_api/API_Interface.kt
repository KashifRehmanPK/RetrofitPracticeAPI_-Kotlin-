package com.neonstudio.retrofitpractice_api

import retrofit2.Call
import retrofit2.http.GET

interface API_Interface {

    @GET("1")
    fun getData(): Call<ResponseModelClass>

}