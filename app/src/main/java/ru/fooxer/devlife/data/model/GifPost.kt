package ru.fooxer.devlife.data.model


/*
 * Created by fooxer on 31.01.2021
 */

data class GifPost (
    val id: Int,
    val description: String?,
    val votes: Int?,
    val author: String?,
    val date: String?,
    val gifURL: String?,
    val gifSize: Int?,
    val previewUR: String?,
    val videoURL: String?,
    val videoPath: String?,
    val videoSize: Int?,
    val type: String?,
    val width: String?,
    val height: String?,
    val commentsCount: Int?,
    val fileSize: Int?,
    val canVote: Boolean = false,
)

/*
{"id":569,"
description":"Когда в команде, много джуниоров",
"votes":329,
"author":"Dezmond",
"date":"Apr 8, 2013 7:12:19 AM",
"gifURL":"http://static.devli.ru/public/images/gifs/201304/146b9164-9985-4ac1-85d2-64c185f9063c.gif",
"gifSize":3310384,
"previewURL":"https://static.devli.ru/public/images/previews/201304/1f5415ba-d034-4567-8ce5-af1af5865648.jpg",
"videoURL":"http://static.devli.ru/public/images/v/201304/3d2a98d1-7d93-49a3-b8c4-12e8867f2cee.mp4",
"videoPath":"/public/images/v/201304/3d2a98d1-7d93-49a3-b8c4-12e8867f2cee.mp4",
"videoSize":168732,"type":"gif","width":"542","height":"300","commentsCount":0,"fileSize":3310384,"canVote":false}
 */