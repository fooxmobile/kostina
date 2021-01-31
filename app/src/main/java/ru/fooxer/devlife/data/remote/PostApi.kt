package ru.fooxer.devlife.data.remote

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import ru.fooxer.devlife.data.model.GifPost


/*
 * Created by fooxer on 31.01.2021
 */

interface PostApi {
    @GET("random?json=true")
    fun getRandomPost(): Single<GifPost>
}