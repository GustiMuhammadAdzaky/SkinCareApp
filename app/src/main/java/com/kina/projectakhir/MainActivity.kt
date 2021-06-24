package com.kina.projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val keluar = intent.getBooleanExtra("EXIT", false)
        if (keluar){
            finish()
        }

        button2.setOnClickListener {
            val pindah = Intent(this@MainActivity,Main2Activity::class.java)
            startActivity(pindah)
        }
    }
}
