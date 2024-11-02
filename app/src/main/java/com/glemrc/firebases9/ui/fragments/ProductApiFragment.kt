package com.glemrc.firebases9.ui.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.glemrc.firebases9.R
import com.glemrc.firebases9.adapter.ProductApiAdapter
import com.glemrc.firebases9.model.ProductApiModel
import com.glemrc.firebases9.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Response

class ProductApiFragment : Fragment() {
    private var productList = listOf<ProductApiModel>()
    private lateinit var  productAdapter: ProductApiAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        val view: View = inflater.inflate(R.layout.fragment_product_api, container, false)
        val rvProductApi = view.findViewById<RecyclerView>(R.id.rvProductApi)
        rvProductApi.layoutManager = LinearLayoutManager(requireContext())

        productAdapter = ProductApiAdapter(productList)
        rvProductApi.adapter = productAdapter



        loadProducts()
        return view
    }

    private fun loadProducts() {
        val call = RetrofitInstance.api.getProducts()
        call.enqueue(object : retrofit2.Callback<List<ProductApiModel>> {
            override fun onResponse(
                call: Call<List<ProductApiModel>>,
                response: Response<List<ProductApiModel>>
            ) {
                if (response.isSuccessful) {
                    productList = response.body() ?: emptyList()
                    productAdapter.updateProductList(productList)

                }
            }

            override fun onFailure(call: Call<List<ProductApiModel>>, t: Throwable) {
                Log.e("ProductApiFragment", "Erro ao carregar produtos", t)

            }
        })
    }
}

