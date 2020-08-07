package com.example.lab8.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab8.ApiUtils
import com.example.lab8.Model
import com.example.lab8.R
import com.example.lab8.adapters.ImageDogAdapter
import com.example.lab8.interfaces.APIUrl
import kotlinx.android.synthetic.main.activity_image_dog.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ImageDogActivity : AppCompatActivity() {
    lateinit var apiUrl: APIUrl
    var name_dog: String = "afghan"

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_dog)

        apiUrl = ApiUtils().getAPIUrl()

        name_dog = intent.getStringExtra("dog_name")

        btnBack.setOnClickListener{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                finishAfterTransition()
            }
        }
        supportActionBar?.setTitle(name_dog)
        getData(name_dog)

    }

    private fun setAdapter(arrayDog: Array<String>) {
        viewManager = GridLayoutManager(this, 2)
        viewAdapter = ImageDogAdapter(this,arrayDog)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView_image).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }

    private fun getData(dog_name: String) {
        apiUrl.getUrlImageList(dog_name).enqueue(object : Callback<Model> {
            override fun onFailure(call: Call<Model>?, t: Throwable?) {
                Log.v("retrofit", "call failed")
            }

            override fun onResponse(call: Call<Model>?, response: Response<Model>?) {
                if (response?.body() != null) {
                    val model: Model = response.body()!!

//                    Log.d("ImageDogActivity", "it works!")
                    val arrayDog: Array<String> = model.listDog!!.toTypedArray()
                    setAdapter(arrayDog)
                }
            }
        })
    }
}