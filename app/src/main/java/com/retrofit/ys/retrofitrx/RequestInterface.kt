package com.retrofit.ys.retrofitrx

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by ys on 2018. 2. 26..
 */
interface RequestInterface {
    @GET("api/android")
    fun getData(): Observable<List<Android>>
}