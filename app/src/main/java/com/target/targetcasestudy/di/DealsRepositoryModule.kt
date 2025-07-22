package com.target.targetcasestudy.di

import com.target.targetcasestudy.data.repo.DealsRepositoryImpl
import com.target.targetcasestudy.domain.DealsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DealsRepositoryModule {

    @Singleton
    @Binds
    abstract fun dealsRepository(repository: DealsRepositoryImpl): DealsRepository

}
