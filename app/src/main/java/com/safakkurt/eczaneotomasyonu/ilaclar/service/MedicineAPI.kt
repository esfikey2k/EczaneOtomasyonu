package com.safakkurt.eczaneotomasyonu.ilaclar.service

import com.safakkurt.eczaneotomasyonu.ilaclar.model.MedicineModel
import retrofit2.Call
import retrofit2.http.GET

interface MedicineAPI {

    @GET("api/medicine?api_key=ffrIFx793Vk880cye2S71cCVUiQSLfq8")
    fun getData():Call<List<MedicineModel>>
    // eski value get= 6625fa029132f30c8a0f
}