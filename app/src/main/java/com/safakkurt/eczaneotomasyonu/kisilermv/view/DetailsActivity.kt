package com.safakkurt.eczaneotomasyonu.kisilermv.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.safakkurt.eczaneotomasyonu.adapter.RecyclerViewAdapter
import com.safakkurt.eczaneotomasyonu.databinding.ActivityDetailsBinding
import com.safakkurt.eczaneotomasyonu.view.MainActivity
import java.util.ArrayList



class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonExitDetails.setOnClickListener {

            val alertDialog=AlertDialog.Builder(this@DetailsActivity)
            alertDialog.setTitle("Çıkış İşlemi")
            alertDialog.setMessage("Çıkış yapmak istediğinizden emin misiniz?")
            alertDialog.setPositiveButton("Evet"){dialog,which->
                val intent=Intent(this@DetailsActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            alertDialog.setNegativeButton("Hayır"){dialog,which->
                Toast.makeText(this@DetailsActivity,"Çıkış işlemi iptal edildi!",Toast.LENGTH_SHORT).show()
            }
            alertDialog.show()


        }

        val intent=intent
        val name=intent.getStringExtra("name")
        val status=intent.getStringExtra("status")
        val tc=intent.getStringExtra("tcNo")
        val total=intent.getStringExtra("total")

        val medicineName: ArrayList<String> = intent.getSerializableExtra("medicineName") as ArrayList<String>
        val medicinePrice: ArrayList<String> = intent.getSerializableExtra("medicinePrice") as ArrayList<String>
        val medicineQuantity: ArrayList<String> = intent.getSerializableExtra("medicineQuantity") as ArrayList<String>
        val medicineImageUrl:ArrayList<String> = intent.getStringArrayListExtra("medicineUrl") as ArrayList<String>
        val medicineType: ArrayList<String> = intent.getSerializableExtra("medicineType") as ArrayList<String>
        val medicineDescription:ArrayList<String> = intent.getSerializableExtra("medicineDescription") as ArrayList<String>
        val xAdet = intent.getIntExtra("xAdet",0)

        println(medicineImageUrl)

        binding.textViewTc.text=tc.toString()
        binding.textViewName.text=name.toString()
        binding.textViewStatus.text=status.toString()
        binding.textViewTotal.text="${total.toString()} ₺"
        binding.textViewToplamIlac.text=xAdet.toString()


        binding.recyclerView.layoutManager=GridLayoutManager(this,2)
        val medicineAdapter = RecyclerViewAdapter(medicineName,medicineQuantity,medicineImageUrl,medicinePrice,medicineType,medicineDescription)
        binding.recyclerView.adapter=medicineAdapter

    }


}




