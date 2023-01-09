package com.kot.yummy.application.service

import com.kot.yummy.application.dto.response.RestaurantResponse

interface RestaurantService {

    fun search(query: String): RestaurantResponse

}