package com.hassan.android.pinviewotp

import android.content.Context
import android.widget.Toast

/*
* Extension function, means showToast method is now added
* as a member method of Context class
*
* */

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}