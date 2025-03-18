package com.example.childmonitoringel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.FirebaseApp
import androidx.appcompat.app.AppCompatActivity

class loginactivity : AppCompatActivity() {
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginactivity)

        // Initialize Firebase
        FirebaseApp.initializeApp(this)

        // Find your views
        val signUpButton = findViewById<Button>(R.id.SignUpbutton)
        val nameField = findViewById<TextInputEditText>(R.id.Name)
        val mailField = findViewById<TextInputEditText>(R.id.Mail)
        val passwordField = findViewById<TextInputEditText>(R.id.password)

        // OnClickListener for SignUp button
        signUpButton.setOnClickListener {
            // Collect data from the input fields
            val name = nameField.text.toString()
            val mail = mailField.text.toString()
            val password = passwordField.text.toString()
            
            // Save to global variables for use in other activities
            Globalvar.mailId = mail
            Globalvar.name = name
            Globalvar.password = password

            // Initialize Crescere database structure if needed
            database = FirebaseDatabase.getInstance().getReference("Crescere")
            
            // Go to the input activity to collect child data
            val intent = Intent(this, input::class.java)
            startActivity(intent)
        }
    }
}


