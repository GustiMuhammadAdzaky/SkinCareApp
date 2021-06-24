package com.kina.projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Main2Activity : AppCompatActivity() {
    private lateinit var rvskinCare: RecyclerView
    private var list: ArrayList<SkinCare> = arrayListOf()
    private var title: String = "Produk"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rvskinCare = findViewById(R.id.rv_skin_care)
        rvskinCare.setHasFixedSize(true)

        list.addAll(SkinCareData.listData)
        showRecyclerCardView()

        setActionBarTitle(title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun setActionBarTitle(title: String) {
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

    private fun showSelectedSkinCare(skinCare: SkinCare) {
        val moveWithDataIntent = Intent(this@Main2Activity, Details::class.java)
        val nama = skinCare.nama
        val detail = skinCare.detail
        val photo = skinCare.photo

        moveWithDataIntent.putExtra(Details.EXTRA_NAMA, "$nama")
        moveWithDataIntent.putExtra(Details.EXTRA_DETAIL,"$detail")
        moveWithDataIntent.putExtra(Details.EXTRA_PHOTO,photo)
        startActivity(moveWithDataIntent)
    }

    private fun showRecyclerCardView() {
        rvskinCare.layoutManager = LinearLayoutManager(this)
        val cardViewAdapter = CardViewAdapter(list)
        rvskinCare.adapter = cardViewAdapter
        cardViewAdapter.setOnItemClickCallback(object : CardViewAdapter.OnItemClickCallback {
            override fun onItemClicked(data: SkinCare) {
                showSelectedSkinCare(data)
            }
        })
    }

}
