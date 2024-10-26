package com.glemrc.firebases9

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etEmailLogin = findViewById<EditText>(R.id.etEmailLogin)
        val etPasswordLogin = findViewById<EditText>(R.id.etPasswordLogin)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val auth = FirebaseAuth.getInstance()

        btnRegister.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btnLogin.setOnClickListener{
            val email = etEmailLogin.text.toString()
            val password = etPasswordLogin.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){task->
                    if(task.isSuccessful){
                        Snackbar.make(findViewById(android.R.id.content), "Login exitoso",
                            Snackbar.LENGTH_SHORT).show()
                        startActivity(Intent(this, PrincipalActivity::class.java))
                    }else{
                        Snackbar.make(findViewById(android.R.id.content), "Error en el login",
                            Snackbar.LENGTH_SHORT).show()
                    }
                }
        }
    }
}