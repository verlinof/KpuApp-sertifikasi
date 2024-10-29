package com.example.kpuapp

import android.content.Intent
import android.os.Bundle
import com.example.kpuapp.databinding.ActivityLoginBinding
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    // Deklarasi View Binding
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inisialisasi binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Logic ketika tombol login ditekan
        binding.btnLogin.setOnClickListener {
            val email = binding.textEmail.text.toString().trim()
            val password = binding.textPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan Password harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                if (validateLogin(email, password)) {
                    showSuccessToast()  // Tampilkan toast kustom saat login berhasil

                    // Arahkan ke halaman Home
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Email atau Password salah!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun validateLogin(email: String, password: String): Boolean {
        // Login sederhana untuk contoh
        return email == "user@example.com" && password == "password"
    }

    private fun showSuccessToast() {
        val inflater = LayoutInflater.from(this)
        val layout = inflater.inflate(R.layout.toast_success, null)

        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.view = layout
        toast.show()
    }
}
