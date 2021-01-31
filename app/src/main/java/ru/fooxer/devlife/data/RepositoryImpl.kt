package ru.fooxer.devlife.data

import android.util.Log
import io.reactivex.rxjava3.core.Single
import ru.fooxer.devlife.data.remote.PostApi
import ru.fooxer.devlife.domain.RepositoryApi
import ru.fooxer.devlife.domain.entiy.GifPostModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiService: PostApi,
    val converter: dagger.Lazy<Converter>
) : RepositoryApi {
    override fun getRandomPost(): Single<GifPostModel> {
        return apiService.getRandomPost()
            .map {
                converter.get().convert(it)
            }
    }
}