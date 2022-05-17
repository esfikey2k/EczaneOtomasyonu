package com.safakkurt.eczaneotomasyonu.kisilermv.model

import com.google.gson.annotations.SerializedName


data class DebtorModel(
    @SerializedName("tc")
    val tc:String,
    @SerializedName("name")
    val name:String,
    @SerializedName("total")
    val total:NumberDecimal,
    @SerializedName("status")
    val status:String,
    @SerializedName("medicine")
    val medicine:List<Medicine>
)

data class Medicine(
    @SerializedName("ilac")
    val ilac:String,
    @SerializedName("quantity")
    val quantity:Int
)

data class NumberDecimal(
    @SerializedName("\$numberDecimal")
    val numberDecimal:String
)