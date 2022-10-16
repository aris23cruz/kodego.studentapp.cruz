package com.kodego.activity.one.studentassistanceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodego.activity.one.studentassistanceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //login
        binding.btnLogin.setOnClickListener(){
            var userName : String = binding.etUserName.text.toString()
            var password : String = binding.etPassword.text.toString()
            checkCredential(userName,password)
        }
    }

   private fun checkCredential(userName: String, password: String): Boolean{
        val correctUserName : String = "Admin"
        val correctPassword : String = "admin123"

       val correctUserName2 : String = "John"
       val correctPassword2 : String = "pass123"

        if((correctUserName == userName)&&(correctPassword == password)){
            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("nameID",userName)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext,"Logged in", Toast.LENGTH_SHORT).show()
            return true
        }else if((correctUserName2 == userName)&&(correctPassword2 == password)) {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("nameID", userName)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Logged in", Toast.LENGTH_SHORT).show()
            return true
        }else{
            Toast.makeText(applicationContext,"Input correct username/password", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}