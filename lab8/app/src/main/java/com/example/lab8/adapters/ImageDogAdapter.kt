package com.example.lab8.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab8.R


class ImageDogAdapter(private val context: Context, private val myDataset: Array<String>) : RecyclerView.Adapter<ImageDogAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        // create a new view
        val imageView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_image, parent, false) as ImageView
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(imageView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

//        Log.d("adapter", myDataset[position])

        Glide.with(context)
            .load(myDataset[position])
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.imageView)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}
