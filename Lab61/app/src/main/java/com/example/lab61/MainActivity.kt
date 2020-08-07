package com.example.lab61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_intent.setOnClickListener {

            val intent = Intent(this, IntentActivity::class.java)
            val bundle = Bundle()
            bundle.putString("IntentValue", "Intent Example")
            intent.putExtra("BundlePackage", bundle)
            startActivity(intent)
        }

        button_intentForResult.setOnClickListener {
            val intent = Intent(this, IntentActivity::class.java)
            val bundle = Bundle()
            bundle.putString("IntentValue", "Intent For Result Example")
            intent.putExtra("BundlePackage", bundle)
            startActivityForResult(intent, 202)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            202 -> {
                val resultData = data?.getStringExtra("IntentForResult")
                Toast.makeText(this, resultData, Toast.LENGTH_LONG).show()
            }
        }
    }
}