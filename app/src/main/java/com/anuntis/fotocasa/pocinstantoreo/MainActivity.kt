package com.anuntis.fotocasa.pocinstantoreo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val uri: Uri by lazy { Uri.parse("http://poc/poc_detail") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOpenFeature.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, uri)
                .addCategory(Intent.CATEGORY_BROWSABLE)
                .addCategory(Intent.CATEGORY_DEFAULT)
            startActivity(intent)
        }
    }
}
