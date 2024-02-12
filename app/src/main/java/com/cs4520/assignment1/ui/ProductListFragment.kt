package com.cs4520.assignment1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cs4520.assignment1.databinding.ProductListFragmentBinding
import com.cs4520.assignment1.databinding.ProductListItemBinding
import com.cs4520.assignment1.logic.Product
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

        productManager = ProductManager().apply { importProductData(productsDataset) }

        with (binding.recyclerView) {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerViewAdapter(productManager.getAllProducts())
        }
    }
}

private class RecyclerViewAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View, val binding: ProductListItemBinding) :
        RecyclerView.ViewHolder(view) {

        fun bind(test: Int) {
            binding.test.text = test.toString()
        }
    }

    /*class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView = view.findViewById<TextView>(R.id.test)
        fun bind(test: Int) {
            textView.text = test.toString()
        }
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        ProductListItemBinding.inflate(LayoutInflater.from(parent.context)).let {
            return ViewHolder(it.root, it)
        }
        /*val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return ViewHolder(view)*/
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = products.size * 10
}