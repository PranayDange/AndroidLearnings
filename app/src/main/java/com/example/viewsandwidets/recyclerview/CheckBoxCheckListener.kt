package com.example.viewsandwidets.recyclerview

import android.view.View

interface CheckBoxCheckListener {

    fun itemChecked(view: View, isChecked: Boolean, position: Int)
}