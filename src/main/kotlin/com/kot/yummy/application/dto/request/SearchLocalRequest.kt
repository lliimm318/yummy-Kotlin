package com.kot.yummy.application.dto.request

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

data class SearchLocalRequest(

    private val query: String = "",

    private val display: Int = 5,

    private val start: Int = 1,

    private val sort: String = "random"

) {
    fun toMap(): MultiValueMap<String, String> {

        val map = LinkedMultiValueMap<String, String>()

        map["query"] = query
        map["display"] = display.toString()
        map["start"] = start.toString()
        map["sort"] = sort

        return map

    }
}