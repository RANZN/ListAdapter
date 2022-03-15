package com.example.listadapter.app.domain.use_cases

import com.example.listadapter.app.domain.repository.Repository

class GetData(private val repository: Repository) {
    operator fun invoke() =
        repository.getData()
}