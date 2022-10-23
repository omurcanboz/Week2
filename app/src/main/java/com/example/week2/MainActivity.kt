package com.example.week2

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.week2.ui.main.MainFragment
import android.view.inputmethod.InputMethodManager

class MainActivity : AppCompatActivity() {

    private lateinit var foodToEat : TextView
    private lateinit var foodToAdd: EditText

    var menu: ArrayList<String> = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_addFood : Button = findViewById(R.id.btn_add)
        var btn_decide : Button = findViewById(R.id.btn_decide)

        btn_addFood.setOnClickListener { addMenu() }
        btn_decide.setOnClickListener { decide() }

        foodToEat = findViewById<Button>(R.id.display_text)
        foodToAdd = findViewById(R.id.edit_text)




    }

    private fun addMenu(){
        if(!foodToAdd.text.toString().equals("") && !menu.contains(foodToAdd.text.toString())){
            menu.add(foodToAdd.text.toString())
        }
        foodToAdd.setText("")
        hideKeyboard(foodToAdd)
    }

    private fun decide(){
        foodToEat.text = menu.random()

    }

    private fun hideKeyboard(v : View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)
    }
}