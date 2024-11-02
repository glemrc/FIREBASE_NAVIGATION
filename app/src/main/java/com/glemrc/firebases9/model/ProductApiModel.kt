package com.glemrc.firebases9.model

data class ProductApiModel(
    val id: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val stock: Int,
    val price: Double,
    val discount: Double,
    val categoryID: Int,
)
