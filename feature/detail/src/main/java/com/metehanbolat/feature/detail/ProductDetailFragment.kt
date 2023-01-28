package com.metehanbolat.feature.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.metehanbolat.core.common.MainUIState
import com.metehanbolat.core.presentation.util.gone
import com.metehanbolat.core.presentation.util.inflate
import com.metehanbolat.core.presentation.util.visible
import com.metehanbolat.feature.detail.databinding.FragmentProductDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment(R.layout.fragment_product_detail) {

    private val args: ProductDetailFragmentArgs by navArgs()
    private val viewModel: ProductDetailViewModel by viewModels()

    private val binding by inflate(FragmentProductDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getProductFromId(args.id)

        viewModel.productState.observe(viewLifecycleOwner) {
            when (it) {
                is MainUIState.Loading -> {
                    binding.loadingLottie.visible()
                }
                is MainUIState.Error -> {
                    binding.loadingLottie.gone()
                    println("productState: Error")
                }
                is MainUIState.Success -> {
                    val product = it.data
                    binding.productImageCard.visible()
                    binding.loadingLottie.gone()
                    Glide.with(requireContext()).load(product.image).into(binding.productImage)
                    binding.productName.text = product.title
                    binding.productDetail.text = product.description
                    binding.productPriceText.text = "${product.price.toString()} ₺"
                }
            }
        }
    }

}