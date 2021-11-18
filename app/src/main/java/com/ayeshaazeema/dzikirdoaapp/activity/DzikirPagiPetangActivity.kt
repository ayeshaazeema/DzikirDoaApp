package com.ayeshaazeema.dzikirdoaapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ayeshaazeema.dzikirdoaapp.MainActivity
import com.ayeshaazeema.dzikirdoaapp.R
import com.ayeshaazeema.dzikirdoaapp.databinding.ActivityDzikirPagiPetangBinding
import com.ayeshaazeema.dzikirdoaapp.model.DzikirDoa

class DzikirPagiPetangActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var dzikirPagiPetangBinding: ActivityDzikirPagiPetangBinding
    private var listDzikirDoa: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dzikirPagiPetangBinding = ActivityDzikirPagiPetangBinding.inflate(layoutInflater)
        setContentView(dzikirPagiPetangBinding.root)

        supportActionBar?.hide()

        dzikirPagiPetangBinding.cvDzikirPagi.setOnClickListener(this)
        dzikirPagiPetangBinding.cvDzikirPetang.setOnClickListener(this)

        back()
    }

    private fun back() {
        dzikirPagiPetangBinding.ivBackPagiPetang.setOnClickListener {
            startActivity(MainActivity.getLaunchService(this))
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.cvDzikirPagi -> startActivity(DzikirPagiActivity.getLaunchService(this))
            R.id.cvDzikirPetang -> startActivity(DzikirPetangActivity.getLaunchService(this))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    companion object {
        fun getLaunchService(from: Context) =
            Intent(from, DzikirPagiPetangActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
    }
}