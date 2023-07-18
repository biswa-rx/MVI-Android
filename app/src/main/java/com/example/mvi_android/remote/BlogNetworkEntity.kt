package com.example.mvi_android.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data  class BlogNetworkEntity(

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("postId")
    @Expose
    var title: Int,

    @SerializedName("name")
    @Expose
    var body: String,

    @SerializedName("email")
    @Expose
    var image: String,

    @SerializedName("body")
    @Expose
    var category: String
)
