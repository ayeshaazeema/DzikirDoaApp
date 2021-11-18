package com.ayeshaazeema.dzikirdoaapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayeshaazeema.dzikirdoaapp.adapter.DzikirDoaAdapter
import com.ayeshaazeema.dzikirdoaapp.databinding.ActivityDzikirPetangBinding
import com.ayeshaazeema.dzikirdoaapp.model.DataDzikirDoa
import com.ayeshaazeema.dzikirdoaapp.model.DzikirDoa

class DzikirPetangActivity : AppCompatActivity() {

    private lateinit var dzikirPetangBinding: ActivityDzikirPetangBinding
    private var listDzikirDoa: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dzikirPetangBinding = ActivityDzikirPetangBinding.inflate(layoutInflater)
        setContentView(dzikirPetangBinding.root)

        supportActionBar?.hide()

        showRecyclerList()
        back()
    }

    private fun back() {
        dzikirPetangBinding.ivBackPetang.setOnClickListener {
            startActivity(DzikirPagiPetangActivity.getLaunchService(this))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showRecyclerList() {
        listDzikirDoa.clear()
        listDzikirDoa.addAll(DataDzikirDoa.listDzikirPetang)

        dzikirPetangBinding.rvPetang.setHasFixedSize(true)
        dzikirPetangBinding.rvPetang.layoutManager = LinearLayoutManager(this)
        dzikirPetangBinding.rvPetang.adapter = DzikirDoaAdapter(listDzikirDoa)
    }

    companion object {
        fun getLaunchService(from: Context) = Intent(from, DzikirPetangActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
}