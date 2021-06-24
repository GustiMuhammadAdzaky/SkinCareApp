package com.kina.projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity() {
    private var title: String = ""

    companion object {
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val tvDataReceived: TextView = findViewById(R.id.tv_item_name)
        val tvDataReceived2: TextView = findViewById(R.id.tv_item_detail)
        val tvDataReceived3= findViewById<ImageView>(R.id.img_item_photo)

        val photo = intent.getIntExtra(EXTRA_PHOTO,0)
        Glide.with(this)
            .load(photo)
            .into(tvDataReceived3)

        val name = intent.getStringExtra(EXTRA_NAMA)
        val detail = intent.getStringExtra(EXTRA_DETAIL)

        tvDataReceived.text = name
        tvDataReceived2.text = detail

        setActionBarTitle(title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        btn_next.setOnClickListener {
            val pindah = Intent(this@Details,LastActivity::class.java)
            startActivity(pindah)
        }
    }

    private fun setActionBarTitle(title: String) {
        var namaProduct = intent.getStringExtra(EXTRA_NAMA)
        var title = "Detail Tentang Product $namaProduct"
        supportActionBar?.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        val benar = super.onBackPressed()
        return benar
    }
}
