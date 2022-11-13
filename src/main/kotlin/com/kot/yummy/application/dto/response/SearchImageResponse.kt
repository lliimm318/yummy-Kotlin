package com.kot.yummy.application.dto.response

data class SearchImageResponse(

    private val lastBuildDate: String,

    private val total: Int,

    private val start: Int,

    private val display: Int,

    private val items: List<SearchImageItem>

) {
    inner class SearchImageItem (

        private val title: String,

        private val link: String,

        private val thumbnail: String,

        private val sizeheight: String,

        private val sizewidth: String
    )
}
