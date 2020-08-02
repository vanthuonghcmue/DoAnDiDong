package com.example.tikicloneapp.Fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tikicloneapp.Activity.DangnhapDangkyActivity
import com.example.tikicloneapp.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile,container,false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layout_login.setOnClickListener {
            //FirebaseAuth.getInstance().signOut()
            val intent = Intent (context, DangnhapDangkyActivity::class.java)
            startActivity(intent)
        }
    }



}