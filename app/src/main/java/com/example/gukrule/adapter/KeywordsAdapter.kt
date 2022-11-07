package com.example.gukrule.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gukrule.R
import com.example.gukrule.keyword.Keyword
import kotlinx.android.synthetic.main.keyword_circle.view.*

class KeywordsAdapter() :
    ListAdapter<Keyword, KeywordsAdapter.KeywordViewHolder>(KeywordDiffCallback) {

    var keywordData = mutableListOf<Keyword>()

    /* ViewHolder for Keyword, takes in the inflated view */
    class KeywordViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
//        private val keywordButton : Button = itemView.keyword_circle
    }

    /* Creates and inflates view and return KeywordViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeywordViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.keyword_circle, parent, false)
        return KeywordViewHolder(view)
    }

    /* keywords to bind view. */
    override fun onBindViewHolder(holder: KeywordViewHolder, position: Int) {
//        val keyword = getItem(position)
//        holder.bind(keyword)
        val keywordCircle = holder.itemView.findViewById<TextView>(R.id.keyword_circle)
        keywordCircle.text = keywordData[position].name
//        holder.bind(keywordData[position])
    }

    override fun getItemCount(): Int {
        return keywordData.size
    }

}

object KeywordDiffCallback : DiffUtil.ItemCallback<Keyword>() {
    override fun areItemsTheSame(oldItem: Keyword, newItem: Keyword): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Keyword, newItem: Keyword): Boolean {
        return oldItem.id == newItem.id
    }
}