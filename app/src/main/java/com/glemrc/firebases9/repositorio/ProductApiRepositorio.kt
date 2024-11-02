package com.glemrc.firebases9.repositorio

import com.glemrc.firebases9.model.ProductApiModel
import com.glemrc.firebases9.service.ProductApiService
import com.glemrc.firebases9.service.RetrofitInstance

class ProductApiRepositorio {

    private val productApiService : ProductApiService = RetrofitInstance.api

    fun getProducts() = productApiService.getProducts()
    fun getProductById(id: Int) = productApiService.getProductById(id)
    fun createProduct(product: ProductApiModel) = productApiService.createProduct(product)
    fun updateProduct(id: Int, product: ProductApiModel) = productApiService.updateProduct(id, product)
    fun deleteProduct(id: Int) = productApiService.deleteProduct(id)
}