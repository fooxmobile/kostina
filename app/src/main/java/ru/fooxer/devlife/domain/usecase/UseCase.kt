package ru.fooxer.devlife.domain.usecase

import io.reactivex.rxjava3.core.Single


/*
 * Created by fooxer on 31.01.2021
 */

interface UseCase<R> {
    fun execute(): Single<R>
}