package ru.fooxer.devlife.data

import ru.fooxer.devlife.data.model.GifPost
import ru.fooxer.devlife.domain.entiy.GifPostModel
import javax.inject.Inject


/*
 * Created by fooxer on 31.01.2021
 */

class Converter @Inject constructor() {
    fun convert(value: GifPost) : GifPostModel {
        return GifPostModel(
            value.id,
            value.description ?: "",
            value.gifURL ?: "",
                )
    }
}