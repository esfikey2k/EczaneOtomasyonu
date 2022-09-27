package com.safakkurt.eczaneotomasyonu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.safakkurt.eczaneotomasyonu.databinding.ActivityMedicineInfoDetailsBinding
import com.squareup.picasso.Picasso

class MedicineInfoDetails : AppCompatActivity() {
    private lateinit var binding: ActivityMedicineInfoDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicineInfoDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        

        val intent=intent

        val infoMedicineName = intent.getStringExtra("recyclerMedicineName")
        val infoMedicinePrice = intent.getStringExtra("recyclerMedicinePrice")
        val infoMedicineDescription = intent.getStringExtra("recyclerMedicineDescription")
        val infoMedicineType = intent.getStringExtra("recyclerMedicineType")
        val infoUrl = intent.getStringExtra("recyclerUrl")
        
        Picasso.get().load(infoUrl).into(binding.imageViewMedicine)

        binding.textViewMedicineName.text=infoMedicineName.toString()
        binding.textViewMedicineDescription.text=infoMedicineDescription.toString()
        binding.textViewMedicinePrice.text="${infoMedicinePrice.toString()}  ₺"
        binding.textViewMedicineType.text=infoMedicineType.toString()

        binding.backButton.setOnClickListener {

            onBackPressed()

        }


    }



}