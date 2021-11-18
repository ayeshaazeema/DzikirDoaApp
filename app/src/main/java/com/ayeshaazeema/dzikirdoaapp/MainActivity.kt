package com.ayeshaazeema.dzikirdoaapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayeshaazeema.dzikirdoaapp.activity.DzikirDoaHarianActivity
import com.ayeshaazeema.dzikirdoaapp.activity.DzikirPagiPetangActivity
import com.ayeshaazeema.dzikirdoaapp.activity.DzikirSetiapSaatActivity
import com.ayeshaazeema.dzikirdoaapp.activity.QauliyahActivity
import com.ayeshaazeema.dzikirdoaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()
        initView()
    }

    private fun initView() {
        mainBinding.llQauliyahMain.setOnClickListener {
            startActivity(QauliyahActivity.getLaunchService(this))
        }
        mainBinding.llDzikirDoaHarian.setOnClickListener {
            startActivity(DzikirDoaHarianActivity.getLaunchService(this))
        }
        mainBinding.llDzikirSetiapSaat.setOnClickListener {
            startActivity(DzikirSetiapSaatActivity.getLaunchService(this))
        }
        mainBinding.llDzikirPagiPetang.setOnClickListener {
            startActivity(DzikirPagiPetangActivity.getLaunchService(this))
        }
    }

    companion object {
        fun getLaunchService(from: Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
}