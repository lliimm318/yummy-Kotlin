package com.kot.yummy.application.dto.request

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

data class SearchImageRequest(

    private val query: String = "",

    private val display: Int = 1,

    private val start: Int = 1,

    private val sort: String = "sim",

    private val filter: String = "all "

) {
    fun toMap(): MultiValueMap<String, String> {

        val map = LinkedMultiValueMap<String, String>()

        map["query"] = query
        map["display"] = display.toString()
        map["start"] = start.toString()
        map["sort"] = sort
        map["filter"] = filter

        return map

    }
}
