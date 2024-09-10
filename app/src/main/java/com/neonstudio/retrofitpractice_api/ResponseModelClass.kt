package com.neonstudio.retrofitpractice_api

data class ResponseModelClass(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)