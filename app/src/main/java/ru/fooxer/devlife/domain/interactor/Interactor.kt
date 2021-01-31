package ru.fooxer.devlife.domain.interactor

import io.reactivex.rxjava3.core.Single
import ru.fooxer.devlife.domain.entiy.GifPostModel

interface Interactor {
    fun randomPost() : Single<GifPostModel>
}