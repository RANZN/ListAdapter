package com.example.listadapter.app.domain.use_cases

import com.example.listadapter.app.domain.repository.Repository

class GetAnotherData(private val repository: Repository) {
    operator fun invoke(pg: Int) = repository.getPagingData(pg)
}