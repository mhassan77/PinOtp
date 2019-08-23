package com.hassan.android.pinviewotp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        /*Toast.makeText(this, msg, Toast.LENGTH_LONG).show()*/

        /*
        * null safe operation
        * safe call ?.
        * safe call with let ?. {}
        *
        * */

        val bundle: Bundle? = intent.extras

        /* below code won't execute if the bundle is null

        bundle?.let {

            val msg: String = bundle.getString(Constants.USER_MSG_KEY)
            showToast("yoyoy",  Toast.LENGTH_LONG)
        }*/


        /* it will show "null" as a toast message
        val msg: String? = bundle?.getString(Constants.USER_MSG_KEY)
        showToast(msg.toString(),  Toast.LENGTH_LONG)*/


        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        recyclerView.adapter = adapter
    }
}