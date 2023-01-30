package com.metehanbolat.core.data.constant

import androidx.annotation.VisibleForTesting
import com.metehanbolat.core.data.dto.ProductResponseItem

const val SAMPLE_RESPONSE_FILE_NAME = "FakeStoreResponse.json"
const val SAMPLE_RESPONSE_FILE_NAME_2 = "FakeStoreResponseItem.json"

val storeDto = ProductResponseItem(
    category = "null",
    description = "null",
    id = 1,
    image = "null",
    price = 13.5,
    rating = null,
    title = "null"
)

@VisibleForTesting(otherwise = 5)
val storeDto2 = ProductResponseItem(
    category = "null",
    description = "null",
    id = 3,
    image = "null",
    price = 12.3,
    rating = null,
    title = "null"
)

val cardList = listOf(storeDto, storeDto2)

val apiException = Exception("Something went wrong")