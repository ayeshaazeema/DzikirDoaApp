package com.ayeshaazeema.dzikirdoaapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayeshaazeema.dzikirdoaapp.MainActivity
import com.ayeshaazeema.dzikirdoaapp.R
import com.ayeshaazeema.dzikirdoaapp.adapter.DzikirDoaAdapter
import com.ayeshaazeema.dzikirdoaapp.databinding.ActivityDzikirDoaHarianBinding
import com.ayeshaazeema.dzikirdoaapp.model.DzikirDoa

class DzikirDoaHarianActivity : AppCompatActivity() {

    private lateinit var dzikirDoaHarianBinding: ActivityDzikirDoaHarianBinding
    private var listDzikirDoaHarian: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dzikirDoaHarianBinding = ActivityDzikirDoaHarianBinding.inflate(layoutInflater)
        setContentView(dzikirDoaHarianBinding.root)

        supportActionBar?.hide()

        showRecyclerList()
        initData()
        back()
    }

    private fun back() {
        dzikirDoaHarianBinding.ivBackHarian.setOnClickListener {
            startActivity(MainActivity.getLaunchService(this))
        }
    }

    private fun initData() {
        val desc = resources.getStringArray(R.array.dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.terjemah_dzikir_doa_harian)

        listDzikirDoaHarian.clear()

        for (data in desc.indices) {
            listDzikirDoaHarian.add(
                DzikirDoa(desc[data], lafaz[data], terjemah[data])
            )
        }
    }

    private fun showRecyclerList() {
        dzikirDoaHarianBinding.rvHarian.setHasFixedSize(true)
        dzikirDoaHarianBinding.rvHarian.layoutManager = LinearLayoutManager(this)
        dzikirDoaHarianBinding.rvHarian.adapter = DzikirDoaAdapter(listDzikirDoaHarian)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    companion object {
        fun getLaunchService(from: Context) =
            Intent(from, DzikirDoaHarianActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
    }
}