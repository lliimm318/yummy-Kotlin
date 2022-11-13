package com.kot.yummy.application.dto.response

data class RestaurantResponse(

    val id: Int,

    var title: String,

    var category: String,

    var address: String,

    var roadAddress: String,

    var imageUrl: String

)
