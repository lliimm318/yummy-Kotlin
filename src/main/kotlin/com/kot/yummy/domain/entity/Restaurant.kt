package com.kot.yummy.domain.entity

import javax.persistence.*

@Entity(name = "yum")
class Restaurant (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int = 0,

    private var title: String = "none",

    private var category: String = "none",

    private var address: String = "none",

    @Column(name = "road_address")
    private var roadAddress: String = "none",

    @Column(name = "image_url")
    private var imageUrl: String = "none"

)