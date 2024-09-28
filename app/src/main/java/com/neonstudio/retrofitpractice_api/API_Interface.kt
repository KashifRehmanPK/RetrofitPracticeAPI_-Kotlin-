package com.neonstudio.retrofitpractice_api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface API_Interface {

    // Create
    //@FormUrlEncoded
    @POST("posts")
    fun createPostItem(@Body postItem: ResponsePostModelClassItem): Call<ResponsePostModelClassItem>
 

    // Read
    @GET("todos/1")
    fun getData(): Call<ResponseModelClass>



//    // Update
//    @PUT("items/{id}")
//    fun updateItem(@Path("id") id: Int, @Body item: Item): Call<Item>
//
//    // Delete
//    @DELETE("items/{id}")
//    fun deleteItem(@Path("id") id: Int): Call<Void>


}