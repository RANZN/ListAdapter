package com.example.listadapter.app.domain.repository

import com.example.listadapter.app.domain.model.ResponseModel
import com.example.listadapter.common.NetworkResult
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getData(): Flow<NetworkResult<ResponseModel>>
    fun getAnotherData(pgNo: Int): Flow<NetworkResult<ResponseModel>>
}