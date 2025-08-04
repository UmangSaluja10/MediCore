package com.example.medicore

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.medicore.databinding.ActivitySigninPageBinding
import com.google.firebase.auth.FirebaseAuth

class signinPage : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySigninPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySigninPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.button.setOnClickListener {
            startActivity(Intent(this,loginPage::class.java))
            finish()
        }
        binding.button2.setOnClickListener {

            val email:String=binding.editTextEmail.text.toString()
            val username:String= binding.editTextUsername.text.toString()
            val password:String= binding.editTextPassword.text.toString()
            val confirmPassword:String= binding.editTextConfirmPassword.text.toString()
            // check if any field is empty
            if(email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
            else if(password != confirmPassword){
                Toast.makeText(this,"Both password should be same!!", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this){ task->
                        if(task.isSuccessful){
                            Toast.makeText(this,"Successfully Registered", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,choice::class.java))
                            finish()
                        }
                        else{
                            Toast.makeText(this,"Registration Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}