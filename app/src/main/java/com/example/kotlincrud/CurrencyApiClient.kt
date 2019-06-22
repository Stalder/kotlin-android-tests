package com.example.kotlincrud

import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.http.*

interface CurrencyApiClient {

    @GET("scripts/XML_daily.asp/")
    fun getCurrencyRate(@Query("date_req") date: String): Observable<ValCurs>

    companion object {

        fun create(): CurrencyApiClient {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(TikXmlConverterFactory.create())
                .baseUrl("http://www.cbr.ru/")
                .build()

            return retrofit.create(CurrencyApiClient::class.java)
        }
    }
}