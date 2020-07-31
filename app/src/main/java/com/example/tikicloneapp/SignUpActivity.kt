package com.example.tikicloneapp

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        button_signup.setOnClickListener{
            CreateAccount()
        }

    }
    private fun CreateAccount() {
        val fullName =fullname_signup.text.toString()
        val phone =phone_signup.text.toString()
        val email =email_signup.text.toString()
        val password =password_signup.text.toString()
        val date = date_signup.text.toString()
         when {
             TextUtils.isEmpty(fullName) -> Toast.makeText ( this, "full name is required", Toast.LENGTH_LONG )
             TextUtils.isEmpty(phone) -> Toast.makeText ( this, "phone is required", Toast.LENGTH_LONG )
             TextUtils.isEmpty(email) -> Toast.makeText ( this, "email is required", Toast.LENGTH_LONG )
             TextUtils.isEmpty(password) -> Toast.makeText ( this, "password is required", Toast.LENGTH_LONG )
             TextUtils.isEmpty(date) -> Toast.makeText ( this, "date is required", Toast.LENGTH_LONG )
             else ->{
                 val progressDialog = ProgressDialog(this@SignUpActivity)
                 progressDialog.setTitle("SignUp")
                 progressDialog.setMessage("Please wait, this may take a while...")
                 progressDialog.setCanceledOnTouchOutside(false)
                 progressDialog.show()

                 val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
                 mAuth.createUserWithEmailAndPassword(email, password)
                     .addOnCompleteListener { task ->
                         if (task.isSuccessful){
                            saveUserInfo(fullName, email, progressDialog, phone, date )
                         }
                         else{
                        val message= task.exception!!.toString()
                             Toast.makeText(this, "Error: $message", Toast.LENGTH_LONG)
                             mAuth.signOut()
                             progressDialog.dismiss()
                         }
                     }


             }
         }

    }

    private fun saveUserInfo(fullName: String, email: String, progressDialog: ProgressDialog, phone:String, date:String ) {
    val currentUserID= FirebaseAuth.getInstance().currentUser!!.uid
    val usersRef: DatabaseReference = FirebaseDatabase.getInstance().reference.child("Users")
    val userMap = HashMap<String, Any>()
        userMap["uid"]= currentUserID
        userMap["fullname"]= fullName.toLowerCase()
        userMap["email"]= email
        userMap["bio"]= "0"
        userMap["phone"]= phone
        userMap["date"]= date
        userMap["image"]= "https://firebasestorage.googleapis.com/v0/b/tiki-clone-app-90eba.appspot.com/o/Default%20Images%2Fb02b05c721d9dd8784c8.jpg?alt=media&token=0b844449-ab82-49e4-9e67-24fbea1db825"

        usersRef.child(currentUserID).setValue(userMap)
            .addOnCompleteListener{
                task ->
                if (task.isSuccessful){
                    progressDialog.dismiss()
                    Toast.makeText(this, "Account has been created successfully.", Toast.LENGTH_LONG)
                        val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                }
                else {
                    val message= task.exception!!.toString()
                    Toast.makeText(this, "Error: $message", Toast.LENGTH_LONG)
                    FirebaseAuth.getInstance().signOut()
                    progressDialog.dismiss()
                }
            }
    }

}