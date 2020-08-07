package com.example.lab8.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab8.ApiUtils
import com.example.lab8.Model
import com.example.lab8.adapters.NameDogAdapter
import com.example.lab8.R
import com.example.lab8.interfaces.APIService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var apiService: APIService

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = ApiUtils().getAPIService()

        btn_getData.setOnClickListener {
            getData()
        }
    }

    private fun setAdapter(arrayDog: Array<String>) {
        viewManager = LinearLayoutManager(this)
        viewAdapter = NameDogAdapter(this, arrayDog)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }

    private fun getData() {
        apiService.getListDog().enqueue(object : Callback<Model> {
            override fun onFailure(call: Call<Model>?, t: Throwable?) {
                Log.v("retrofit", "call failed")
            }

            override fun onResponse(call: Call<Model>?, response: Response<Model>?) {
                if (response?.body() != null) {
                    val model: Model = response.body()!!

                    Log.d("MainActivity", model.listDog.toString())
                    val arrayDog: Array<String> = model.listDog!!.toTypedArray()
                    setAdapter(arrayDog)
                }
            }
        })
    }


}


