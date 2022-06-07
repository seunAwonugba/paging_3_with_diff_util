package com.example.base.remote.data

import com.google.gson.annotations.SerializedName

data class TopicSubmissions(

    @SerializedName("business-work")
    val business_work: BusinessWork,
    val experimental: Experimental,
    val fashion: Fashion,
    val people: People,
    val spirituality: Spirituality,
    val wallpapers: Wallpapers
)