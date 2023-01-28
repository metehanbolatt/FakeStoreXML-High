package com.metehanbolat.core.data.extension

import com.metehanbolat.core.data.dto.ProductResponseItem
import com.metehanbolat.core.domain.model.ProductItem
import com.metehanbolat.core.domain.model.Rating

fun ProductResponseItem.toProductItem(): ProductItem {
    val rating = rating?.let { Rating(it.count, it.rate) }
    return ProductItem(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        rating = rating,
        title = title
    )
}