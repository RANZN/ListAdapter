package com.example.listadapter.app.data.remote

import com.example.listadapter.app.domain.model.ResponseModel
import com.example.listadapter.common.Constants.HEADER_HOST
import com.example.listadapter.common.Constants.HEADER_KEY
import com.example.listadapter.common.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiClient {
    @GET("feeds/list")
    suspend fun getData(
        @Header("x-rapidapi-host") host: String = HEADER_HOST,
        @Header("x-rapidapi-key") key: String = HEADER_KEY
    ): ResponseModel
}