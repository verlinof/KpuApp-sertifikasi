package com.example.kpuapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.kpuapp.databinding.ActivityDetailDataBinding

class DetailDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDataBinding
    private lateinit var databaseHelper: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databaseHelper = Database(this)

        val userId = intent.getIntExtra("user_id", -1)
        if (userId != -1) {
            val user = databaseHelper.getDetailsUser(userId)
            user?.let {
                with(binding){
                    textNama.setText(user.name)
                    textNik.setText(user.nik)
                    textAlamat.setText(user.address)
                    textNoHP.setText(user.phone)
                    textGender.setText(user.gender)
                    DatePicker.setText(user.date)
                    Glide.with(this@DetailDataActivity).load(user.image).centerCrop().into(image)
                }
            }
        }
    }
}