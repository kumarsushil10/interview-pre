package com.swan.roomretrofitmvvmhilt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swan.roomretrofitmvvmhilt.databinding.RecyclerListItemLayoutBinding
import com.swan.roomretrofitmvvmhilt.models.ProductsItem

class ProductListAdapter(private val productList: List<ProductsItem>) : RecyclerView.Adapter<ProductListAdapter.ItemViewHolder>() {

    private lateinit var binding: RecyclerListItemLayoutBinding
    class ItemViewHolder(binding: RecyclerListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = RecyclerListItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return  productList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        with(holder){
            with(productList[position]){
                binding.productTitle.text = this.title
                Glide.with(itemView).load(this.image).into(binding.productImg)
            }
        }
    }

}