package com.ayeshaazeema.dzikirdoaapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayeshaazeema.dzikirdoaapp.MainActivity
import com.ayeshaazeema.dzikirdoaapp.adapter.DzikirDoaAdapter
import com.ayeshaazeema.dzikirdoaapp.databinding.ActivityDzikirSetiapSaatBinding
import com.ayeshaazeema.dzikirdoaapp.model.DataDzikirDoa
import com.ayeshaazeema.dzikirdoaapp.model.DzikirDoa

class DzikirSetiapSaatActivity : AppCompatActivity() {

    private lateinit var dzikirSetiapSaatBinding: ActivityDzikirSetiapSaatBinding
    private var listDzikirSetiapSaat: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dzikirSetiapSaatBinding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        setContentView(dzikirSetiapSaatBinding.root)

        supportActionBar?.hide()

        showRecyclerList()
        back()
    }

    private fun back() {
        dzikirSetiapSaatBinding.ivBackSetiapSaat.setOnClickListener {
            startActivity(MainActivity.getLaunchService(this))
        }
    }

    private fun showRecyclerList() {
        listDzikirSetiapSaat.clear()
        listDzikirSetiapSaat.addAll(DataDzikirDoa.listDzikir)

        dzikirSetiapSaatBinding.rvSetiapSaat.layoutManager = LinearLayoutManager(this)
        dzikirSetiapSaatBinding.rvSetiapSaat.adapter = DzikirDoaAdapter(listDzikirSetiapSaat)
        dzikirSetiapSaatBinding.rvSetiapSaat.setHasFixedSize(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    companion object {
        fun getLaunchService(from: Context) =
            Intent(from, DzikirSetiapSaatActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
    }
}