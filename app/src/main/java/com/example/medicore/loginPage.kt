package com.example.medicore

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.medicore.databinding.ActivityLoginPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class loginPage : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginPageBinding
    override fun onStart() {
        super.onStart()
        val currentUser : FirebaseUser? = auth.currentUser
        if(currentUser != null){
            startActivity(Intent(this,choice::class.java))
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=FirebaseAuth.getInstance()

        binding.button.setOnClickListener {
            val email:String = binding.editTextLoginUsername.text.toString()
            val pass:String =binding.editTextLoginPassword.text.toString()
            if(email.isEmpty()||pass.isEmpty()){
                Toast.makeText(this,"Please fill all the details", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.signInWithEmailAndPassword(email,pass)
                    .addOnCompleteListener { task->
                        if(task.isSuccessful){
                            Toast.makeText(this,"Login Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,choice::class.java))
                            finish()
                        }
                        else{
                            Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this,signinPage::class.java))
            finish()
        }
    }
}