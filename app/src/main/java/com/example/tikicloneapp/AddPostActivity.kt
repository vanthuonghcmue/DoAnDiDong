package com.example.tikicloneapp

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import com.theartofdev.edmodo.cropper.CropImage
import kotlinx.android.synthetic.main.activity_add_post.*
import com.theartofdev.edmodo.cropper.CropImage.activity as activity1

class AddPostActivity : AppCompatActivity() {
    private var myUrl=""
    private var imageUri: Uri?=null
    private var storagepostPicRef: StorageReference?= null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        storagepostPicRef= FirebaseStorage.getInstance().reference.child("posts pictures")

        save.setOnClickListener{updoadImage()}
        activity1()
            .setAspectRatio(4,6)
            .start(this@AddPostActivity)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data!=null){
         val result= CropImage.getActivityResult(data)
            imageUri= result.uri
            image_post.setImageURI(imageUri)
        }
    }

    private fun updoadImage() {
        when{
            imageUri== null-> Toast.makeText(this, "please select image.",Toast.LENGTH_LONG).show()
             TextUtils.isEmpty(ten_sach.text.toString())-> Toast.makeText(this, "pleas write name", Toast.LENGTH_LONG).show()
            TextUtils.isEmpty(GiaBan.text.toString())-> Toast.makeText(this, "pleas write Gia Ban", Toast.LENGTH_LONG).show()
            TextUtils.isEmpty(GiaGoc.text.toString())-> Toast.makeText(this, "pleas write Gia Goc", Toast.LENGTH_LONG).show()
            TextUtils.isEmpty(GiamGia.text.toString())-> Toast.makeText(this, "pleas write Giam gia", Toast.LENGTH_LONG).show()

            else-> {
                    val progressDialog= ProgressDialog(this)
                    progressDialog.setTitle("Adding New product")
                    progressDialog.setMessage("pleas wait, we are updating your product")
                    progressDialog.show()




                    val fileRef = storagepostPicRef!!.child(System.currentTimeMillis().toString() + ".jpg")
                   var uploadTask: StorageTask<*>
                  uploadTask = fileRef.putFile(imageUri!!)

                    uploadTask.continueWithTask( Continuation< UploadTask.TaskSnapshot, Task<Uri>> { task ->
                        if (!task.isSuccessful)
                        {
                            task.exception?.let{
                            throw it
                            progressDialog.dismiss()

                        }

                        }
                        return@Continuation fileRef.downloadUrl
                    })
                        .addOnCompleteListener(OnCompleteListener <Uri>{ task ->
                            if (task.isSuccessful){
                                val downloadUri= task.result
                                myUrl =downloadUri.toString()

                                val ref =FirebaseDatabase.getInstance().reference.child("Post")
                                val postId= ref.push().key
                                val postMap =HashMap<String, Any>()
                                postMap["postid"]=postId!!
                                postMap["name"]= ten_sach.text.toString().toLowerCase()
                                postMap["giaban"]= Integer.parseInt( GiaBan.text.toString())
                                postMap["giagoc"]= Integer.parseInt(GiaGoc.text.toString())
                                postMap["giamgia"]= Integer.parseInt(GiamGia.text.toString())
                                postMap["hinh"]= myUrl

                                ref.child(postId).updateChildren(postMap)
                                Toast.makeText(this, "Post uploaded successfully", Toast.LENGTH_LONG).show()
                                val intent=Intent(this@AddPostActivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                                progressDialog.dismiss()
                            }
                            else {
                                progressDialog.dismiss()
                            }
                        })

            }
        }
    }
}
