package com.example.tikicloneapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tikicloneapp.Model.Post
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_product_detail.*

class activity_product_detail : AppCompatActivity() {
    private var productId: String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)


        userInfo()
    }

    private fun userInfo(){
        val productRef = FirebaseDatabase.getInstance().getReference().child("Post").child(productId)

        productRef.addValueEventListener(object : ValueEventListener
        {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    val produc =snapshot.getValue(Post::class.java)
                    textView_name.setText( produc!!.getname())
                    textView_priceDiscount.setText( produc!!.getgiaban())
                    textView_priceOrigin.setText(produc!!.getgiagoc())
                    textView_discount.setText(produc!!.getgiamgia())
                }
            }

        })
    }
}