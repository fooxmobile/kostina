package ru.fooxer.devlife.domain

import io.reactivex.rxjava3.core.Single
import ru.fooxer.devlife.domain.entiy.GifPostModel

interface RepositoryApi {
    fun getRandomPost() : Single<GifPostModel>
}