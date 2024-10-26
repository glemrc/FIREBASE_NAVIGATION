package com.glemrc.firebases9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.glemrc.firebases9.R
import com.glemrc.firebases9.model.ProductModel
import com.squareup.picasso.Picasso

class ProductAdapter (private var lstProduct : List<ProductModel>):
        RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

            class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
                {
                    val ivProduct = itemView.findViewById<ImageView>(R.id.ivProduct)
                    val tvName = itemView.findViewById<TextView>(R.id.tvName)
                    val tvStock = itemView.findViewById<TextView>(R.id.tvStock)
                    val tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)

                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_product, parent, false))
    }

    override fun getItemCount(): Int {
        return lstProduct.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemProduct = lstProduct[position]
        holder.tvName.text = itemProduct.name
        holder.tvStock.text = itemProduct.stock
        holder.tvPrice.text = itemProduct.price
        Picasso.get().load(itemProduct.imageUrl).into(holder.ivProduct)
    }
}

