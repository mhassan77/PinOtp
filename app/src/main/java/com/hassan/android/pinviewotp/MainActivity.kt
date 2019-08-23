package com.hassan.android.pinviewotp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        val TAG_ACTIVITY = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //text.setText("Hello bro cool day")
        showBTN.setOnClickListener {
            val name: String = editText.text.toString()
            text.text = name

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, "")
            startActivity(intent)
        }

        share.setOnClickListener {
            val name = editText.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, name)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share on: "))
        }

        Log.d(TAG_ACTIVITY, "cool")


    }
}
