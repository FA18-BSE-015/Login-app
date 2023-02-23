package com.example.portal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    private lateinit var button3:Button
    private lateinit var username: EditText

    private lateinit var password:EditText
    private lateinit var cpassword:EditText
    private lateinit var db:DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        username = findViewById(R.id.editTextTextPersonName)
        password = findViewById(R.id.editTextTextPassword2)
        cpassword =findViewById(R.id.editTextTextPassword3)
        db = DBHelper(this)
        button3=findViewById(R.id.button3)
         button3.setOnClickListener{
             val usernametext =username.text.toString()
             val passwordtext= password.text.toString()
             val cpasswordtext =cpassword.text.toString()
             val savedata = db.insertdata(usernametext,passwordtext)
             if(TextUtils.isEmpty(usernametext) || TextUtils.isEmpty(passwordtext) || TextUtils.isEmpty(cpasswordtext)){
                 Toast.makeText(this, "Add Username, Password and Confrm password", Toast.LENGTH_SHORT).show()
             }
                 else{
                     if(passwordtext.equals(cpasswordtext)){
                         if(savedata==true){

                             Toast.makeText(this, "Signup successful",Toast.LENGTH_SHORT).show()
                             val intent= Intent(applicationContext,MainActivity::class.java)
                             startActivity(intent)
                         }
                         else{
                             Toast.makeText(this, "user exist",Toast.LENGTH_SHORT ).show()

                         }
                     }
                     else{
                         Toast.makeText(this,"Password not match",Toast.LENGTH_SHORT).show()
                     }
                 }
             }

         }


    }
