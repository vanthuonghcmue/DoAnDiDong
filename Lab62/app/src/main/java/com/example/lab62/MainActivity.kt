package com.example.lab62

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnStartBoundService: Button

    private lateinit var btnStopBoundService: Button
    private lateinit var btnSeek: Button
    private lateinit var connection: ServiceConnection
    private var isBound = false
    private lateinit var serviceExample: ServiceExample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connection = object : ServiceConnection {
            // Phương thức này được hệ thống gọi khi kết nối tới service bị lỗi
            override fun onServiceDisconnected(name: ComponentName) {
                isBound = false
            }
            // Phương thức này được hệ thống gọi khi kết nối tới service thành công
            override fun onServiceConnected(name: ComponentName, service: IBinder) {
                val binder = service as ServiceExample.MyBinder
                serviceExample = binder.getService() // lấy đối tượng MyService
                isBound = true
            }
        }



    }


    override fun onClick(v: View) {
        val intent = Intent(this, ServiceExample::class.java)
        intent.putExtra("DATA_SERVICE", "Data từ activity truyền sang Service")
        when (v.id) {
            R.id.btn_startService -> {
                startService(intent)
            }
            R.id.btn_stopService -> {
                stopService(intent)
            }

            R.id.btn_stopBoundService -> {
// Nếu Service đang hoạt động
                if (isBound) {
// Tắt Service
                    unbindService(connection)
                    isBound = false
                }
            }
            R.id.btn_seek -> {
// nếu service đang hoạt động
                if (isBound) {
// tua bài hát
                    serviceExample.fastForward()
                } else {
                    Toast.makeText(this, "Service chưa hoạt động", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}