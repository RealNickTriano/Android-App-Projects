package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// constant for base URL for the web service
    private const val BASE_URL =
        "https://android-kotlin-fun-mars-server.appspot.com"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // Retrofit builder to build and create a Retrofit object
    private val retrofit = Retrofit.Builder()
        // Retrofit has a ScalarsConverter that supports strings and other primitive types,
        // so you call addConverterFactory() on the builder with an instance of ScalarsConverterFactory.
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        // add the base URI
        .baseUrl(BASE_URL)
        // call build() to create the Retrofit object
        .build()

    // defines how Retrofit talks to the web server using HTTP requests
    interface MarsApiService {
        // tells Retrofit this is a GET request and specifies endpoint
        @GET("photos")
        suspend fun getPhotos(): List<MarsPhoto>

    }

    // public object to init the Retrofit service
    // singleton that can be accessed from the rest of the app
    object MarsApi {
        val retrofitService : MarsApiService by lazy {
            retrofit.create(MarsApiService::class.java) }
        }

