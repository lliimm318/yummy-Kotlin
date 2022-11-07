package com.kot.yummy.application.client

import com.kot.yummy.application.dto.request.SearchLocalRequest
import com.kot.yummy.application.dto.response.SearchLocalResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Component
data class NaverClient(

    @Value("\${naver.client.id}")
    private val naverClientId: String,

    @Value("\${naver.client.secret}")
    private val naverSecret: String,

    @Value("\${naver.url.search.local}")
    private val naverLocalSearchUrl: String,

    @Value("\${naver.url.search.image}")
    private val naverImageSearchUrl: String

) {

    fun localSearch(searchLocalRequest: SearchLocalRequest): SearchLocalResponse {
        val uri = UriComponentsBuilder
            .fromUriString(naverLocalSearchUrl)
            .queryParams(searchLocalRequest.toMap())
            .build()
            .encode()
            .toUri()

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.set("X-Naver-Client-Id", naverClientId)
        headers.set("X-Naver-Client-Secret", naverSecret)

        val httpEntity = HttpEntity<Map<String, Any>>(headers)
        val responseType = ParameterizedTypeReference<SearchLocalResponse>()

        val restTemplate = RestTemplate()
            .exchange(
                uri, HttpMethod.GET, httpEntity, ParameterizedTypeReference
            )

        return restTemplate
    }

    fun imageSearch(): Unit {

    }
}

