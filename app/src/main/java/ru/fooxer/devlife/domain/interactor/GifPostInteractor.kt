package ru.fooxer.devlife.domain.interactor

import android.util.Log
import io.reactivex.rxjava3.core.Single
import ru.fooxer.devlife.domain.entiy.GifPostModel
import ru.fooxer.devlife.domain.usecase.GetPostUseCase
import javax.inject.Inject


/*
 * Created by fooxer on 31.01.2021
 */

class GifPostInteractor @Inject constructor(
    val gifPostUseCase: GetPostUseCase,
) : Interactor {
    override fun randomPost(): Single<GifPostModel> {
        return gifPostUseCase.execute()
    }

}