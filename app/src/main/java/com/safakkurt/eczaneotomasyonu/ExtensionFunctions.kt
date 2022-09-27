package com.safakkurt.eczaneotomasyonu

import android.content.Context
import android.widget.Toast

infix fun Context.toastMessage(message:String){
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
}