package com.example.petarrandjelovic112_21_rnrma.ui.logIn

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.petarrandjelovic112_21_rnrma.MainActivity
import com.example.petarrandjelovic112_21_rnrma.R
import java.util.Objects


class LogInActivity : AppCompatActivity() {


    private var editTextUserName: EditText? = null

    private var editTextEmail: EditText? = null

    private var editTextPassword: EditText? = null

    private val textViewUserName: TextView? = null

    private val textViewMail: TextView? = null


    private var logInBtn: Button? = null

    private var eventViewModel: LogInViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.log_in_activity)
        init()
    }


    private fun init() {
        initView()
        initListeners()
    }

    private fun initView() {
        eventViewModel =
            ViewModelProvider(Objects.requireNonNull(this)).get(LogInViewModel::class.java)

        editTextUserName = findViewById<EditText>(R.id.usernameEditText)
        editTextPassword = findViewById<EditText>(R.id.passwordEditText)
        logInBtn = findViewById<Button>(R.id.buttonLogIn)
        val sharedPref =
            this.applicationContext.getSharedPreferences("projekat1.user", MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("is_logged_in", false)
        val logged = sharedPref.getString("projekat1.logged", "")
        if (logged == "yes") {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        //  System.out.println(usernameP+" "+isLoggedIn+" PROVERI");
    }

    private fun initListeners() {
        logInBtn!!.setOnClickListener { v: View? ->

            //        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            //      startActivity(intent); //intent poziva HomeActivity iz MainActivity
            //gasi se MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) //intent poziva HomeActivity iz MainActivity

            finish() //gasi se MainActivity

        }
    }

}