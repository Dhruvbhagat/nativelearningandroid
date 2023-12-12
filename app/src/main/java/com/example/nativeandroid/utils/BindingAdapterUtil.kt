package com.example.nativeandroid.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.nativeandroid.R

@BindingAdapter("loadImage")
fun loadImage(thumbimg : ImageView, url : String){
    Glide.with(thumbimg)
        .load(url)
        .circleCrop()
        .placeholder(R.drawable.ic_launcher_foreground)
        .error(R.drawable.ic_launcher_foreground)
        .fallback(R.drawable.ic_launcher_foreground)
        .into(thumbimg)

}