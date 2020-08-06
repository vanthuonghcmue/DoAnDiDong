package com.example.tikicloneapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.tikicloneapp.Model.Post
import com.example.tikicloneapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.squareup.picasso.Picasso

class PostAdapter(
    private val mContext: Context,
    private val mPost: List<Post>): RecyclerView.Adapter<PostAdapter.ViewHolder>() {
   inner class ViewHolder (@NonNull itemView: View): RecyclerView.ViewHolder(itemView){
       var postimage:ImageView
        var tikiimage:ImageView
        var namesach: TextView
        var giaban: TextView
       var giagoc: TextView
        var giamgia: TextView
        init {
            postimage= itemView.findViewById(R.id.sachMeVaBe)
            tikiimage= itemView.findViewById(R.id.tikinow)
            giaban= itemView.findViewById(R.id.giabansach)
            giagoc= itemView.findViewById(R.id.giagocsach)
            giamgia= itemView.findViewById(R.id.giamgiasach)
            namesach= itemView.findViewById(R.id.namesach)
        }

   }
    private var firebaseUser: FirebaseUser?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.posts_layout,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  mPost.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        firebaseUser= FirebaseAuth.getInstance().currentUser
        val post =mPost[position]

        getView(post, holder )
    }

    @SuppressLint("SetTextI18n")
    private fun getView(_post: Post, holder: ViewHolder ){
        holder.namesach.setText(_post.getname())
        holder.giaban.setText(_post.getgiaban().toString()+"đ")
        holder.giamgia.setText("-"+_post.getgiamgia().toString()+"%")
        holder.giagoc.setText(_post.getgiagoc().toString()+"đ")
        Picasso.get().load(_post.gethinh()).placeholder(R.drawable.mevabe).into(holder.postimage)

    }
}


private  fun publisherInfo(postimage: ImageView, tikiimage:ImageView,
                           namesach: TextView,
                           giaban: TextView, giagoc: TextView, giamgia: TextView, publicerID:String){
    
    

//    val SachRef = FirebaseDatabase.getInstance().reference.child("Sach").child(publicerID)
//    SachRef.addValueEventListener(object : ValueEventListener{
//        override fun onCancelled(error: DatabaseError) {
//            TODO("Not yet implemented")
//        }
//
//        override fun onDataChange(snapshot: DataSnapshot) {
//            if(snapshot.exists()){
//                val sach=snapshot.getValue<Post>(Post::class.java)
//
//                Picasso.get().load(sach!!.gethinh()).placeholder(R.drawable.profile).into(postimage)
//                namesach.text= sach!!.getname().toString()
//                giaban.text = sach!!.getgiaban().toString()
//                giagoc.text= sach!!.getgiagoc().toString()
//                giamgia.text=sach!!.getgiamgia().toString()
//            }
//        }
//
//    })
}





