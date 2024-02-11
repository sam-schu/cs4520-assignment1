package com.cs4520.assignment1.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cs4520.assignment1.databinding.ProductListFragmentBinding
import com.cs4520.assignment1.logic.ProductManager
import com.cs4520.assignment1.productsDataset

class ProductListFragment : Fragment() {
    private lateinit var binding: ProductListFragmentBinding
    private lateinit var productManager: ProductManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ProductListFragmentBinding.inflate(inflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productManager = ProductManager()
        productManager.importProductData(productsDataset)
    }
}