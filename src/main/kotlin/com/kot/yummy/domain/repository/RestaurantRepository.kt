package com.kot.yummy.domain.repository

import com.kot.yummy.domain.entity.Restaurant
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RestaurantRepository: CrudRepository<Restaurant, Int> {

}