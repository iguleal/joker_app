package com.example.jokerapp.model

import com.google.gson.annotations.SerializedName


data class Joke(
    @SerializedName("value") val txtJoke: String,
    @SerializedName("icon_url")val iconUrl: String
)
