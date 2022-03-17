package com.example.listadapter.app.data.repository

import com.example.listadapter.app.data.remote.ApiClient
import com.example.listadapter.app.domain.model.ResponseModel
import com.example.listadapter.app.domain.repository.Repository
import com.example.listadapter.common.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class RepositoryImpl(private val apiClient: ApiClient) : Repository {
    override fun getData(): Flow<NetworkResult<ResponseModel>> =
        flow {
            emit(NetworkResult.Loading())
            try {
                emit(NetworkResult.Success(apiClient.getData()))
            } catch (e: Exception) {
                emit(NetworkResult.Error(e.localizedMessage))
            }
        }

    override fun getAnotherData(pg: Int): Flow<NetworkResult<ResponseModel>> =
        flow {
            emit(NetworkResult.Loading())
            try {
                emit(NetworkResult.Success(apiClient.getData(pgNo = pg)))
            } catch (e: Exception) {
                emit(NetworkResult.Error(e.localizedMessage))
            }
        }
}