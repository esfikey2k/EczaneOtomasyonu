package com.safakkurt.eczaneotomasyonu.kisiler.service



import com.safakkurt.eczaneotomasyonu.kisiler.model.DebtorModel
import retrofit2.Call
import retrofit2.http.GET

interface DebtorAPI {

    @GET("api/debts?api_key=ffrIFx793Vk880cye2S71cCVUiQSLfq8")
    fun getData(): Call<List<DebtorModel>>
    //eski get = b9ab36c883215e19cd1e

}