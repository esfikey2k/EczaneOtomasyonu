package com.safakkurt.eczaneotomasyonu.kisilermv.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.safakkurt.eczaneotomasyonu.databinding.ActivityDetailsBinding
import java.io.Serializable
import java.util.ArrayList

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent=intent
        val name=intent.getStringExtra("name")
        val status=intent.getStringExtra("status")
        val tc=intent.getStringExtra("tcNo")
        val total=intent.getStringExtra("total")
        var all= intent.getStringExtra("all")
        //var medicine=intent.getStringExtra("liste")
        //var medicine=intent.getStringArrayListExtra("liste")--
        //val price=intent.getStringExtra("price")
        //val quantity=intent.getStringExtra("quantity")
        //medicine= medicine?.plus(" $price") as ArrayList<String>?--
        /*if (medicine != null) {
            medicine= medicine.subSequence(1,medicine.length-1).toString()
        }*/

        if (all != null) {
            all= all.subSequence(1,all.length-1).toString()
            all= all.replace(","," ")

        }


        binding.textViewTc.text=tc.toString()
        binding.textViewName.text=name.toString()
        binding.textViewStatus.text=status.toString()
        binding.textViewTotal.text=total.toString()
        binding.textViewMedicineName.text=all.toString()
       /*binding.textViewPrice.text=price.toString()
        binding.textViewMedicineName.text=medicine.toString()
        binding.textViewQuantity.text=quantity.toString()*/
    }
}

