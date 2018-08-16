package com.moyuusa.moyuusalist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val myDataset:List<RowData>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    // https://developer.android.com/guide/topics/ui/layout/recyclerview

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.

    private lateinit var iconImageView : ImageView
    private lateinit var conTextView : TextView

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.ViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_list, parent, false) as View
        // set the view's size, margins, paddings and layout parameters

        iconImageView = view.findViewById(R.id.content_icon)
        conTextView = view.findViewById(R.id.content_text)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.view. = myDataset[position]
        iconImageView.setImageResource(myDataset[position].iconID)
        conTextView.text = myDataset[position].title
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}