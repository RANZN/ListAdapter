package com.example.listadapter.di

import com.example.listadapter.app.data.repository.RepositoryImpl
import com.example.listadapter.app.domain.repository.Repository
import com.example.listadapter.app.domain.use_cases.GetAnotherData
import com.example.listadapter.app.domain.use_cases.GetData
import com.example.listadapter.app.domain.use_cases.UseCases
import org.koin.dsl.module

val appModule = module {
    single<Repository> { RepositoryImpl(get()) }

    single { UseCases(get(),get()) }
    single { GetData(get()) }
    single { GetAnotherData(get()) }
}