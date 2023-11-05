package com.example.viewsandwidets.recyclerview

import android.view.View
@FunctionalInterface
interface RemoveButtonListenerInterface {
    fun removeButtonClicked(view: View, position:Int)
}
