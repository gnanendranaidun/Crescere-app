package com.example.childmonitoringel

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import androidx.appcompat.app.AppCompatActivity
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.TextView
import android.view.View

class input : AppCompatActivity() {
    // Firebase Database reference
    private lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        // Initialize Firebase Database
        database = FirebaseDatabase.getInstance().getReference("Crescere")

        // Find views
        val nameField = findViewById<TextInputEditText>(R.id.inputName)
        val ageField = findViewById<TextInputEditText>(R.id.inputAge)
        val weightField = findViewById<TextInputEditText>(R.id.inputWeight)
        val btnintent = findViewById<Button>(R.id.submitbut)
        val inputId = findViewById<TextInputEditText>(R.id.inputId)
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)

        // Create a spinner for set selection
        val setSpinner = findViewById<Spinner>(R.id.setSpinner)
        val sets = arrayOf("set 1", "set 2", "set 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sets)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        setSpinner.adapter = adapter

        btnintent.setOnClickListener {
            // Collect user input data
            val name = nameField.text.toString().trim()
            val age = ageField.text.toString().trim()
            val weight = weightField.text.toString().trim()
            val id = inputId.text.toString()
            val selectedGenderId = radioGroupGender.checkedRadioButtonId
            val selectedGender = findViewById<RadioButton>(selectedGenderId)?.text.toString()
            val selectedSet = setSpinner.selectedItem.toString()

            // Save data to global variables
            Globalvar.weight = weight
            Globalvar.age = age
            Globalvar.id = id
            Globalvar.gender = selectedGender
            Globalvar.currentSet = selectedSet

            // Navigate to Camera activity
            val intent = Intent(applicationContext, Camera::class.java)
            startActivity(intent)
        }
    }
}

// Data class to store user input
/*data class UserInput(
    val name: String,
    val age: String,
    val weight: String
)*/