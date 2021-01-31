package ru.fooxer.devlife.domain.usecase

import android.util.Log
import io.reactivex.rxjava3.core.Single
import ru.fooxer.devlife.data.RepositoryImpl
import ru.fooxer.devlife.domain.entiy.GifPostModel
import javax.inject.Inject

class GetPostUseCase @Inject constructor(val apiRepo: RepositoryImpl) : UseCase<GifPostModel> {
    override fun execute(): Single<GifPostModel> {
        return apiRepo.getRandomPost()
    }
}