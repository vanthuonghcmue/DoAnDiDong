package com.example.lab61

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        val packageBundle = intent.getBundleExtra("BundlePackage")
        val intentValue = packageBundle.getString("IntentValue")
        var txtValue = findViewById<TextView>(R.id.textView_intent)
        var btnBackWithResult = findViewById<Button>(R.id.button_backWithResult)
        txtValue.text = intentValue
        btnBackWithResult.setOnClickListener { backForResult() }

    }


    private fun backForResult() {
        val intent = intent
        intent.putExtra("IntentForResult", "This is Intent For Result")
        setResult(202, intent)
        finish()
    }
}