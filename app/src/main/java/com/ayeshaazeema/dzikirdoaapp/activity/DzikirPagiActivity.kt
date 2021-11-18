package com.ayeshaazeema.dzikirdoaapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayeshaazeema.dzikirdoaapp.adapter.DzikirDoaAdapter
import com.ayeshaazeema.dzikirdoaapp.databinding.ActivityDzikirPagiBinding
import com.ayeshaazeema.dzikirdoaapp.model.DataDzikirDoa
import com.ayeshaazeema.dzikirdoaapp.model.DzikirDoa

class DzikirPagiActivity : AppCompatActivity() {

    private lateinit var dzikirPagiBinding: ActivityDzikirPagiBinding
    private var listDzikirPagi: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dzikirPagiBinding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        setContentView(dzikirPagiBinding.root)

        supportActionBar?.hide()

        showRecyclerList()
        back()
    }

    private fun back() {
        dzikirPagiBinding.ivBackPagi.setOnClickListener {
            startActivity(DzikirPagiPetangActivity.getLaunchService(this))
        }
    }

    private fun showRecyclerList() {
        listDzikirPagi.clear()
        listDzikirPagi.addAll(DataDzikirDoa.listDzikirPagi)

        dzikirPagiBinding.rvPagi.setHasFixedSize(true)
        dzikirPagiBinding.rvPagi.layoutManager = LinearLayoutManager(this)
        dzikirPagiBinding.rvPagi.adapter = DzikirDoaAdapter(listDzikirPagi)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        fun getLaunchService(from: Context) = Intent(from, DzikirPagiActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
}