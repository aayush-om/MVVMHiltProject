package com.example.mvvmwithhilt.model

import com.google.gson.annotations.SerializedName

data class MarvelModelItem(

    @SerializedName("bio")
    val bio: String,

    @SerializedName("createdby")
    val createdBy: String,

    @SerializedName("firstappearance")
    val firstAppearance: String,

    @SerializedName("imageurl")
    val imageUrl: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("publisher")
    val publisher: String,

    @SerializedName("realname")
    val realName: String,

    @SerializedName("team")
    val team: String,
)