package com.metehanbolat.feature.home

import android.view.View
import com.metehanbolat.core.presentation.ProductUIData
import com.metehanbolat.core.presentation.base.BaseAdapter
import com.metehanbolat.core.presentation.util.loadImage
import com.metehanbolat.feature.home.databinding.AllProductItemBinding

class AllProductAdapter : BaseAdapter<ProductUIData>(R.layout.all_product_item) {

    override fun bind(
        itemView: View,
        item: ProductUIData,
        position: Int,
        viewHolder: BaseViewHolderImpl
    ) {
        val binding = AllProductItemBinding.bind(itemView)
        binding.apply {
            itemName.text = item.name
            itemImage.loadImage(item.imageUrl)
        }
    }

}