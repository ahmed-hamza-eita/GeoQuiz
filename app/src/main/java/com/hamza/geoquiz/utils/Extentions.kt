package com.hamza.geoquiz.utils;

import android.app.Activity
  import android.widget.Toast

fun Activity.showToast(message: Any?) {
    Toast.makeText(this, "$message", Toast.LENGTH_LONG).show()
}


