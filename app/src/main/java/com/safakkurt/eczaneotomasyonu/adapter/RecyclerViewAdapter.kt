package com.safakkurt.eczaneotomasyonu.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.safakkurt.eczaneotomasyonu.R
import com.safakkurt.eczaneotomasyonu.databinding.RecyclerRowBinding
import com.safakkurt.eczaneotomasyonu.view.MedicineInfoDetails
import com.squareup.picasso.Picasso
import java.util.ArrayList


class RecyclerViewAdapter(val mnArrayList: ArrayList<String>, val nmArrayList: ArrayList<String>,val imageUrlList:ArrayList<String>,val medicinePrice:ArrayList<String>,val medicineType:ArrayList<String>,val medicineDescription:ArrayList<String>): RecyclerView.Adapter<RecyclerViewAdapter.MyHolder>() {


    class MyHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
       val binding= RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyHolder(binding)
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.binding.textViewMName.text= mnArrayList.get(position)    //medicine name
        holder.binding.textViewMAdet.text = nmArrayList.get(position)   //medicine quantity

        Picasso.get().load(imageUrlList.get(position)).into(holder.binding.itemImage)
        holder.itemView.setOnClickListener {

            val intent= Intent(holder.itemView.context,MedicineInfoDetails::class.java)
            intent.putExtra("recyclerMedicineName",mnArrayList.get(position))
            intent.putExtra("recyclerMedicineType",medicineType.get(position))
            intent.putExtra("recyclerMedicinePrice",medicinePrice.get(position))
            intent.putExtra("recyclerMedicineDescription",medicineDescription.get(position))
            intent.putExtra("recyclerUrl",imageUrlList.get(position))
            holder.itemView.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return mnArrayList.size
    }


}

