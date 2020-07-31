package com.example.tikicloneapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tikicloneapp.Model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_account_setting.*

class AccountSettingActivity : AppCompatActivity() {
    private lateinit var firebaseUser:FirebaseUser
    private var checker=""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_setting)

       firebaseUser= FirebaseAuth.getInstance().currentUser!!





        button_logout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()

            val intent = Intent(this@AccountSettingActivity, SignInActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
        button_save.setOnClickListener{
            if(checker=="clicked"){


            }
            else{
                updateUserInfoOnly()
            }
        }
        userInfo()
    }

    private fun updateUserInfoOnly() {
        when {
            TextUtils.isEmpty(hoten.text.toString()) -> {
                Toast.makeText(this, "Tên không thể trống", Toast.LENGTH_LONG).show()

            }
            emailprofile.text.toString()=="" -> {
                Toast.makeText(this, "Email không thể trống", Toast.LENGTH_LONG).show()

            }
            sodt.text.toString()=="" -> {
                Toast.makeText(this, "Số Điện thoại không thể trống", Toast.LENGTH_LONG).show()

            }
            editText_date.text.toString()=="" -> {
                Toast.makeText(this, "ngày sinh không thể trống", Toast.LENGTH_LONG).show()

            }
            else -> {

                val usersRef =  FirebaseDatabase.getInstance().reference.child("Users")
                val userMap = HashMap<String, Any>()

                userMap["fullname"] = hoten.text.toString().toLowerCase()
                userMap["email"] = emailprofile.text.toString()
                userMap["phone"] = sodt.text.toString()
                userMap["date"] = editText_date.text.toString()
                usersRef.child(firebaseUser.uid).updateChildren(userMap)
                Toast.makeText(this, "Account has been updated successfully.", Toast.LENGTH_LONG)
                val intent = Intent(this@AccountSettingActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }


    private fun userInfo(){
        val usersRef = FirebaseDatabase.getInstance().getReference().child("Users").child(firebaseUser.uid)

        usersRef.addValueEventListener(object : ValueEventListener
        {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    val user =snapshot.getValue(User::class.java)
                    hoten.setText( user!!.getFullname())
                    emailprofile.setText( user!!.getEmail())
                    sodt.setText(user!!.getPhone())
                    editText_date.setText(user!!.getDate())
                }
            }

        })
    }
}