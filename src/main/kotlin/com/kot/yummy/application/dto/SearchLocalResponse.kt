package com.kot.yummy.application.dto

data class SearchLocalResponse (

    private val lastBuildDate: String,

    private val total: Int,

    private val start: Int,

    private val display: Int,

    private val items: List<SearchLocalItem>


) {
    inner class SearchLocalItem (

        private val title: String,

        private val link: String,

        private val category: String,

        private val description: String,

        private val telephone: String,

        private val address: String,

        private val roadAddress: String,

        private val mapx: Int,

        private val mapy: Int

    )
}