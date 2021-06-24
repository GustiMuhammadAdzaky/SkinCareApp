package com.kina.projectakhir

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_last.*
import kotlin.system.exitProcess

class LastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        btn_keluar.setOnClickListener {
            val keluar = Intent(applicationContext,MainActivity::class.java)
            keluar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            keluar.putExtra("EXIT",true)
            startActivity(keluar)
        }
    }



}
