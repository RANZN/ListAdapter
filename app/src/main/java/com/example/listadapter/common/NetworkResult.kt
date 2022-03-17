package com.example.listadapter.common

sealed class NetworkResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : NetworkResult<T>(data = data)
    class Loading<T> : NetworkResult<T>()
    class Error<T>(message: String?) : NetworkResult<T>(message = message)
}

enum class Response {
    Success,
    Loading,
    Error
}
