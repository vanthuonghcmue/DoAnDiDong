package com.example.lab63

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            AsyncTaskDemo(this).execute()
        }
    }

    class AsyncTaskDemo() : AsyncTask<Void, Int, Void>() {
        private lateinit var mContext: AppCompatActivity

        constructor (context: AppCompatActivity) : this() {
            mContext = context
        }

        override fun onPreExecute() {
            super.onPreExecute()
            Toast.makeText(mContext, "Start", Toast.LENGTH_LONG).show()
        }

        override fun doInBackground(vararg params: Void?): Void? {
//Hàm được được hiện tiếp sau hàm onPreExecute()
//Hàm này thực hiện các tác vụ chạy ngầm
//Tuyệt đối k vẽ giao diện trong hàm này
            for (i in 0..100) {
                SystemClock.sleep(100)
//khi gọi hàm này thì onProgressUpdate sẽ thực thi

                publishProgress(i)
            }
            return null
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
//Thông qua contextCha để lấy được control trong MainActivity
            var progressBar = mContext.findViewById<ProgressBar>(R.id.prbDemo)
//vì publishProgress chỉ truyền 1 đối số
//nên mảng values chỉ có 1 phần tử
            val number = values[0]
//tăng giá trị của Progressbar lên
            progressBar.progress = number!!
//đồng thời hiện thị giá trị là % lên TextView
            val textView = mContext.findViewById<TextView>(R.id.txtStatus)
            textView.text = "$number"
        }

        override fun onPostExecute(aVoid: Void?) {
            super.onPostExecute(aVoid)
//Hàm này được thực hiện khi tiến trình kết thúc
//Ở đây mình thông báo là đã "Finshed" để người dùng biết
            Toast.makeText(mContext, "Okie, Finished", Toast.LENGTH_LONG).show()
        }
    }
}
