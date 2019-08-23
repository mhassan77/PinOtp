package com.hassan.android.pinviewotp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_items.view.*

class HobbiesAdapter(val context: Context, val hobbies: List<Hobby> ) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(holder: ViewGroup, position: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_items, holder, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies.get(position)
        holder.setData(hobby, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var currentPosition: Int = 0
        private var currentHobby: Hobby?= null

        init {
            itemView.setOnClickListener{
                context.showToast(currentHobby!!.title + " " )
            }
            itemView.imgShare.setOnClickListener{
                val name = "send text" + currentHobby!!.title
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, name)
                intent.type = "text/plain"

                context.startActivity(Intent.createChooser(intent, "Share on: "))
            }
        }

        fun setData(hobby: Hobby?, position : Int) {
            itemView.txvTitle.text = hobby!!.title
            Log.d("position:::: ", position.toString())
            this.currentPosition = position
            this.currentHobby = hobby
        }


    }
}