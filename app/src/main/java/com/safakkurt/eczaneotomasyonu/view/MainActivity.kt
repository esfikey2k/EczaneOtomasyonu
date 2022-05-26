package com.safakkurt.eczaneotomasyonu.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.safakkurt.eczaneotomasyonu.databinding.ActivityMainBinding
import com.safakkurt.eczaneotomasyonu.ilaclarmv.imodel.MedicineModel
import com.safakkurt.eczaneotomasyonu.ilaclarmv.iservice.MedicineAPI

import com.safakkurt.eczaneotomasyonu.kisilermv.model.DebtorModel

import com.safakkurt.eczaneotomasyonu.kisilermv.service.DebtorAPI
import com.safakkurt.eczaneotomasyonu.kisilermv.view.DetailsActivity
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val BASE_URL="https://eczane-otomasyon.herokuapp.com/"
    //private val BASE_URL="https://api.npoint.io/"  -> eski api
    //https://eczane-otomasyon.herokuapp.com/api/debts?api_key=ffrIFx793Vk880cye2S71cCVUiQSLfq8  kisiler apisi
    //https://eczane-otomasyon.herokuapp.com/api/medicine?api_key=ffrIFx793Vk880cye2S71cCVUiQSLfq8 ilaclar apisi
    private var debtorModels:ArrayList<DebtorModel>?=null
    private var medicineModels:ArrayList<MedicineModel>?=null
    private var tcArrayList=ArrayList<String>()
    private var ilacIdArrayList=ArrayList<String>()
    private var medicineNameArrayList = ArrayList<String>()
    private var medicinePriceArrayList = ArrayList<String>()

    private var sendMedicineNameArrayList = ArrayList<String>()
    private var sendMedicinePriceArrayList = ArrayList<String>()
    private var sendMedicineQuantityArrayList = ArrayList<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent=intent
        loadData()



    }

    private fun loadData(){

        val retrofit2=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service2=retrofit2.create(MedicineAPI::class.java)

        val call2=service2.getData()

        call2.enqueue(object:Callback<List<MedicineModel>>{
            override fun onResponse(
                call: Call<List<MedicineModel>>,
                response: Response<List<MedicineModel>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        medicineModels=ArrayList(it)
                        medicineModels?.let {
                            for(veriler in medicineModels!!){
                                println(veriler)

                            }
                            val ilacListUzunlugu=medicineModels!!.size-1

                            for(i in 0..ilacListUzunlugu){
                                ilacIdArrayList.add(medicineModels!![i]._id)
                                medicineNameArrayList.add(medicineModels!![i].name.toString())
                                medicinePriceArrayList.add(medicineModels!![i].price.numberDecimal.toString())
                            }


                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<MedicineModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })




        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service=retrofit.create(DebtorAPI::class.java)

        val call=service.getData()

        call.enqueue(object:Callback<List<DebtorModel>>{
            override fun onResponse(
                call: Call<List<DebtorModel>>,
                response: Response<List<DebtorModel>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        debtorModels=ArrayList(it)
                        debtorModels?.let {


                            //Toast.makeText(this@MainActivity,"veriler geldi!",Toast.LENGTH_LONG).show()
                            binding.buttonLogin.setOnClickListener {


                                val lengthOfList=debtorModels!!.size-1

                                for(i in 0..lengthOfList){

                                    tcArrayList.add(debtorModels!![i].tc)
                                }

                                val editTextTc = binding.editTextTc.text.toString()
                                val editTextSifre = binding.editTextPassword.text.toString()
                                val sira= tcArrayList.indexOf(editTextTc).toString()
                                val tcNo=tcArrayList.get(sira.toInt())
                                if(editTextTc.isNotEmpty() && editTextSifre.isNotEmpty()){
                                    if(editTextTc==tcNo.toString() && editTextSifre==tcNo.toString()){

                                        val name=debtorModels!![sira.toInt()].name.toString()
                                        val status=debtorModels!![sira.toInt()].status.toString()
                                        val total=debtorModels!![sira.toInt()].total.numberDecimal.toString()

                                        val kacAdetIlac= debtorModels!![sira.toInt()].medicine.size
                                        val kacAdetIlacUzunlugu= kacAdetIlac-1

                                        for(k in 0..kacAdetIlacUzunlugu){
                                            val ilacIdDebtor= debtorModels!![sira.toInt()].medicine.get(k).ilac.toString()
                                            val medicineQuantity=debtorModels!![sira.toInt()].medicine.get(k).quantity.toString()
                                            val medicineIdSirasi=ilacIdArrayList.indexOf(ilacIdDebtor).toString()
                                            val medicine= medicineNameArrayList.get(medicineIdSirasi.toInt())
                                            val medicinePrice=medicinePriceArrayList.get(medicineIdSirasi.toInt())

                                            sendMedicineNameArrayList.add(k,medicine)
                                            sendMedicinePriceArrayList.add(k,medicinePrice)
                                            sendMedicineQuantityArrayList.add(k,medicineQuantity)


                                        }
                                        println("ilaç ismi gönderilen: ${sendMedicineNameArrayList.toString()}")
                                        val intent=Intent(this@MainActivity,DetailsActivity::class.java)
                                        intent.putExtra("name",name)
                                        intent.putExtra("status",status)
                                        intent.putExtra("tcNo",tcNo)
                                        intent.putExtra("medicineName",sendMedicineNameArrayList as Serializable)
                                        intent.putExtra("medicinePrice",sendMedicinePriceArrayList as Serializable)
                                        intent.putExtra("medicineQuantity",sendMedicineQuantityArrayList as Serializable)
                                        intent.putExtra("xAdet",kacAdetIlac)


                                        intent.putExtra("total",total)

                                        startActivity(intent)
                                        finish()
                                    }else{
                                        Toast.makeText(this@MainActivity,"TC YA DA ŞİFRE YANLIŞ!",Toast.LENGTH_LONG).show()
                                    }
                                }else{
                                    Toast.makeText(this@MainActivity,"TC YA DA ŞİFRE BOŞ!",Toast.LENGTH_LONG).show()
                                }

                            }


                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<DebtorModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }



}

private fun Intent.putParcelableArrayListExtra(s: String, sendMedicinePriceArrayList: ArrayList<String>) {

}
