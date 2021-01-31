package ru.fooxer.devlife

import dagger.Component
import ru.fooxer.devlife.data.remote.ApiModule
import ru.fooxer.devlife.domain.di.DomainModule

@Component (modules = [
DomainModule::class,
ApiModule::class,
])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
}