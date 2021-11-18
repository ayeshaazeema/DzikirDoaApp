package com.ayeshaazeema.dzikirdoaapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayeshaazeema.dzikirdoaapp.MainActivity
import com.ayeshaazeema.dzikirdoaapp.adapter.DzikirDoaAdapter
import com.ayeshaazeema.dzikirdoaapp.databinding.ActivityQauliyahBinding
import com.ayeshaazeema.dzikirdoaapp.model.DataDzikirDoa
import com.ayeshaazeema.dzikirdoaapp.model.DzikirDoa

class QauliyahActivity : AppCompatActivity() {

    private lateinit var qauliyahBinding: ActivityQauliyahBinding
    private var listQauliyah: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        qauliyahBinding = ActivityQauliyahBinding.inflate(layoutInflater)
        setContentView(qauliyahBinding.root)

        supportActionBar?.hide()

        showRecycler()
        back()
    }

    private fun back() {
        qauliyahBinding.ivBackQauliyah.setOnClickListener {
            startActivity(MainActivity.getLaunchService(this))
        }
    }

    private fun showRecycler() {
        listQauliyah.clear()
        listQauliyah.addAll(DataDzikirDoa.listQauliyah)

        qauliyahBinding.rvQauliyah.layoutManager = LinearLayoutManager(this)
        qauliyahBinding.rvQauliyah.adapter = DzikirDoaAdapter(listQauliyah)
        qauliyahBinding.rvQauliyah.setHasFixedSize(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    companion object {
        fun getLaunchService(from: Context) = Intent(from, QauliyahActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
}