package com.safakkurt.eczaneotomasyonu.ilaclar.model

import com.google.gson.annotations.SerializedName

data class MedicineModel(
    val _id:String,
    val name:String,
    val medicineType:String,
    val description:String,
    val image:String,
    val price:NumberDecimal
)

data class NumberDecimal(
    @SerializedName("\$numberDecimal")
    val numberDecimal:String
)
