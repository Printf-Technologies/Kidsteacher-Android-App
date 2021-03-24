package com.printf.kidsteacher.api

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient private constructor(val context: Context) {

    var apiInterface: ApiInterface

    companion object {
        private var instance: ApiClient? = null

        val LIVE_URL = "http://kidsteacher.printftech.com/"

        fun instance(context: Context): ApiClient {
            if (instance == null) {
                instance = ApiClient(context.applicationContext)
            }
            return instance!!
        }
    }

    init {
        apiInterface = this.createService()
    }

    private fun createService(): ApiInterface {
        val clientBuilder = OkHttpClient.Builder()

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        clientBuilder.addInterceptor(interceptor)

        clientBuilder.addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                // get bearer token from SharedPreference after login
                // var token = SharedPreference(context).getValueString(Constant.BEARER_TOKEN)

                var request: Request = chain.request()
                //var headers = request.headers.newBuilder().add("Authorization", "Bearer $token").build() // set Authorization
                var headers = request.headers.newBuilder().add("ak", "81fbdb2a74eb884248d7dbb7c40184de57157ca3c0f53d64f4d92a3f00a283c1dc1d681ab594c4199622b1466dd61396fb51db5b4b8eb26bd7b78a8ccef32546").build() // set Authorization
                request = request.newBuilder().headers(headers).build() // set header in request

                return chain.proceed(request)
            }
        })

        clientBuilder.connectTimeout(15, TimeUnit.SECONDS)
        clientBuilder.readTimeout(15, TimeUnit.SECONDS)
        clientBuilder.writeTimeout(15, TimeUnit.SECONDS)

        val gson = GsonBuilder()
                .setLenient()
                .create()

        val client = clientBuilder.build()

        val retrofit = Retrofit.Builder()
                .baseUrl(LIVE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        return retrofit.create(ApiInterface::class.java)
    }

}