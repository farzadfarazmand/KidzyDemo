package com.github.farzadfarazmand.kidzydemo.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide
        .with(context)
        .load(url)
        .centerCrop()
        .into(this)

}

fun ImageView.loadCircleImage(url: String) {
    Glide
        .with(context)
        .load(url)
        .circleCrop()
        .into(this)

}