package com.example.portal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MainActivity : AppCompatActivity() {
    private lateinit var button:  Button
    private lateinit var button2: Button
    private lateinit var editusername: EditText
    private lateinit var editpassword: EditText
    private lateinit var dbh: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            button =findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        editusername=findViewById(R.id.editTextTextPersonName4)
        editpassword=findViewById(R.id.editTextTextPassword)
        dbh = DBHelper(this)
        button.setOnClickListener{
            val usernametext =editusername.text.toString()
            val passwordtext=editpassword.text.toString()
            if(TextUtils.isEmpty(usernametext) || TextUtils.isEmpty(passwordtext)){
                Toast.makeText(this, " Add Username and Password", Toast.LENGTH_SHORT).show()

            }
            else{
                val checkuser= dbh.checkuserpress(usernametext,passwordtext)
                if(checkuser==true){
                    Toast.makeText(this, "login successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, SigInActivity::class.java)
                    startActivity(intent)

                }
                else{
                    Toast.makeText(this,"Wrong username and Password",Toast.LENGTH_SHORT).show()

                }
            }
        }

        button2.setOnClickListener {
            val intent = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(intent)
        }

/**
        val loginButton = findViewById<Button>(R.id.button)
        val signupButton = findViewById<Button>(R.id.button2)

        loginButton.setOnClickListener {
            // Handle login button click
            val username = findViewById<EditText>(R.id.button).text.toString()
            val password = findViewById<EditText>(R.id.button2).text.toString()
            // Validate username and password
            // If valid, login the user and navigate to the next screen
            // If invalid, show an error message
        }

        signupButton.setOnClickListener {
            // Handle signup button click
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }**/
    }
}
