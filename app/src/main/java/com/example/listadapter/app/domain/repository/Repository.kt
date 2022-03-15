package com.example.listadapter.app.domain.repository

import com.example.listadapter.app.domain.model.ResponseModel
import com.example.listadapter.common.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface Repository {
    fun getData(): Flow<Resource<ResponseModel>>
}