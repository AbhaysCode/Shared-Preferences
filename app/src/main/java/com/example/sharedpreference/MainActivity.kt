package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()
        val etName = findViewById<EditText>(R.id.etName)
        val etDescription = findViewById<EditText>(R.id.etDescription)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnLoad = findViewById<Button>(R.id.btnLoad)
        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val description = etDescription.text.toString()
            etName.text = null
            etDescription.text = null
            editor.apply{
                putString("name",name)
                putString("description",description)
                apply()
            }
        }
        btnLoad.setOnClickListener {
            val name = sharedPref.getString("name",null)
            val description = sharedPref.getString("description",null)
            etName.setText(name)
            etDescription.setText(description)
        }

    }
}