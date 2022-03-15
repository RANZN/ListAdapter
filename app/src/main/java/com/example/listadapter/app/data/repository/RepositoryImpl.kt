package com.example.listadapter.app.data.repository

import com.example.listadapter.app.data.remote.ApiClient
import com.example.listadapter.app.domain.model.ResponseModel
import com.example.listadapter.app.domain.repository.Repository
import com.example.listadapter.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class RepositoryImpl(private val apiClient: ApiClient) : Repository {
    override fun getData(): Flow<Resource<ResponseModel>> =
        flow {
            emit(Resource.Loading())
            try {
                emit(Resource.Success(apiClient.getData()))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
}