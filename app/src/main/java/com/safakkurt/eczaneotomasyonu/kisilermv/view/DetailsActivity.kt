package com.safakkurt.eczaneotomasyonu.kisilermv.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.safakkurt.eczaneotomasyonu.InfoMedicineRecycler
import com.safakkurt.eczaneotomasyonu.R
import com.safakkurt.eczaneotomasyonu.adapter.RecyclerViewAdapter
import com.safakkurt.eczaneotomasyonu.databinding.ActivityDetailsBinding
import com.safakkurt.eczaneotomasyonu.kisilermv.model.DebtorModel
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

        val medicineName: ArrayList<String> = intent.getSerializableExtra("medicineName") as ArrayList<String>
        val medicinePrice: ArrayList<String> = intent.getSerializableExtra("medicinePrice") as ArrayList<String>
        val medicineQuantity: ArrayList<String> = intent.getSerializableExtra("medicineQuantity") as ArrayList<String>
        val xAdet = intent.getIntExtra("xAdet",0)

        /*
        var all= intent.getStringExtra("all")
        if (all != null) {
            all= all.subSequence(1,all.length-1).toString()
            all= all.replace(","," ")

        }*/


        binding.textViewTc.text=tc.toString()
        binding.textViewName.text=name.toString()
        binding.textViewStatus.text=status.toString()
        binding.textViewTotal.text="${total.toString()} ₺"
        binding.textViewToplamIlac.text=xAdet.toString()

        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        val medicineAdapter = RecyclerViewAdapter(medicineName,medicineQuantity)
        binding.recyclerView.adapter=medicineAdapter

    }


}




