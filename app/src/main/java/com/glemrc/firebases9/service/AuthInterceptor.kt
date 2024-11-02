package com.glemrc.firebases9.service

import okhttp3.Interceptor
import okhttp3.Response



class AuthInterceptor (private val token: String): Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(name = "Authorization", value = "Bearer $token")
            .build()
        return chain.proceed(request)
    }

}
