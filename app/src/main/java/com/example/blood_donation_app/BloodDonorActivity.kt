package com.example.blood_donation_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blood_donation_app.R
import com.example.blood_donation_app.adapters.BloodDonorAdapter
import com.example.blood_donation_app.models.BloodDonorModel

class BloodDonorActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blood_donors)
        //
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val bloodDonors: ArrayList<BloodDonorModel> = ArrayList()

// Create dummy data for blood donors
        for (i in 1..100000) {
            val donor = BloodDonorModel(
                pic = R.drawable.a_neg,
                name = "Donor $i",
                age = 25 + i,
                bloodType = "O+",
                contactNumber = "123456789$i",
                email = "donor$i@example.com",
                address = "Address $i"
            )
            bloodDonors.add(donor)
        }

// Create the RecyclerView adapter and pass the bloodDonors list
        val adapter = BloodDonorAdapter(bloodDonors)

// Set the adapter to your RecyclerView
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        //
    }
}