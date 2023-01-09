package com.kot.yummy.application.service

import com.kot.yummy.application.client.NaverClient
import com.kot.yummy.application.dto.request.SearchLocalRequest
import com.kot.yummy.application.dto.response.RestaurantResponse
import com.kot.yummy.domain.repository.RestaurantRepository
import org.springframework.stereotype.Service

@Service
class RestaurantServiceImpl(

    private val restaurantRepository: RestaurantRepository,
    private val naverClient: NaverClient,

) : RestaurantService {

    override fun search(query: String): RestaurantResponse {

        var search =

    }


}