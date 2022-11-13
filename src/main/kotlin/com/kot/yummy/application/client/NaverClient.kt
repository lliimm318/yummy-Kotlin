package com.kot.yummy.application.client

import com.kot.yummy.application.dto.request.SearchImageRequest
import com.kot.yummy.application.dto.request.SearchLocalRequest
import com.kot.yummy.application.dto.response.SearchImageResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.*
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

    fun localSearch(searchLocalRequest: SearchLocalRequest): SearchImageResponse? {
        val uri = UriComponentsBuilder
            .fromUriString(naverLocalSearchUrl)
            .queryParams(searchLocalRequest.toMap())
            .build()
            .encode()
            .toUri()

        val headers = HttpHeaders()
        headers["X-Naver-Client-Id"] = naverClientId
        headers["X-Naver-Client-Secret"] = naverSecret
        headers.contentType = MediaType.APPLICATION_JSON

        val httpEntity = HttpEntity<Any>(headers)
        val responseType: ParameterizedTypeReference<SearchImageResponse?> =
            object : ParameterizedTypeReference<SearchImageResponse?>() {}

        val restTemplate = RestTemplate()
            .exchange(
                uri, HttpMethod.GET, httpEntity, responseType
            )

        return restTemplate.body
    }

    fun imageSearch(searchImageRequest: SearchImageRequest): SearchImageResponse? {
        val uri = UriComponentsBuilder
            .fromUriString(naverImageSearchUrl)
            .queryParams(searchImageRequest.toMap())
            .build()
            .encode()
            .toUri()

        val headers = HttpHeaders()
        headers["X-Naver-Client-Id"] = naverClientId
        headers["X-Naver-Client-Secret"] = naverSecret
        headers.contentType = MediaType.APPLICATION_JSON

        val httpEntity = HttpEntity<Any>(headers)
        val responseType: ParameterizedTypeReference<SearchImageResponse?> =
            object : ParameterizedTypeReference<SearchImageResponse?>() {}


        val responseEntity: ResponseEntity<SearchImageResponse?> = RestTemplate()
            .exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
            )

        return responseEntity.getBody()
    }
}

