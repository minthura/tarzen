package tech.min.tarzen.ui.main

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("visibility")
fun bindVisibility(view: View, isVisible: Boolean?){
    if(isVisible == null) return
    view.visibility = if(isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun bindImageUrl(imageView: ImageView, imageUrl: String?){
    if(imageUrl == null) return
    Glide.with(imageView).load(imageUrl).into(imageView)
}