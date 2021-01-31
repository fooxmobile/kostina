package ru.fooxer.devlife.domain.di

import dagger.Binds
import dagger.Module
import ru.fooxer.devlife.data.RepositoryImpl
import ru.fooxer.devlife.domain.interactor.GifPostInteractor
import ru.fooxer.devlife.domain.interactor.Interactor
import ru.fooxer.devlife.domain.RepositoryApi


@Module
interface DomainModule {
    @Binds
    fun providePostRepository(repository: RepositoryImpl) : RepositoryApi

    @Binds
    fun providePostInteractor(intreactor: GifPostInteractor) : Interactor
}
