package com.orders.delivery.classes

import android.content.Context
import android.graphics.BitmapFactory
import android.view.ViewGroup
import android.widget.ImageView

class GlobalFunctions {
    companion object {
        fun disableLayout(layout: ViewGroup) {
            layout.isEnabled = false
            for (i in 0 until layout.childCount) {
                val child = layout.getChildAt(i)
                if (child is ViewGroup) {
                    disableLayout(child)
                } else {
                    child.isEnabled = false
                }
            }
        }

        fun enableLayout(layout: ViewGroup) {
            layout.isEnabled = true
            for (i in 0 until layout.childCount) {
                val child = layout.getChildAt(i)
                if (child is ViewGroup) {
                    enableLayout(child)
                } else {
                    child.isEnabled = true
                }
            }
        }
    }
}