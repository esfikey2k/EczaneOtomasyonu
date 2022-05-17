package com.safakkurt.eczaneotomasyonu.ilaclarmv.imodel

import com.google.gson.annotations.SerializedName

data class MedicineModel(
    val _id:String,
    val name:String,
    val price:NumberDecimal
)

data class NumberDecimal(
    @SerializedName("\$numberDecimal")
    val numberDecimal:String
)
