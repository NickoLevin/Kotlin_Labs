package com.example.fragmentapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentapplication.databinding.RecyclerItemBinding

class LineAdapter: RecyclerView.Adapter<LineAdapter.LineHolder>() {
    val lineList = ArrayList<String>()
    class LineHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = RecyclerItemBinding.bind(item)
        fun bind(line: String){
            binding.textViewLarge.text = line
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return LineHolder(view)
    }

    override fun onBindViewHolder(holder: LineHolder, position: Int) {
        holder.bind(lineList[position])
    }

    override fun getItemCount(): Int {
        return lineList.size
    }
    fun addLine(line: String){
        lineList.add(line)
        notifyDataSetChanged()
    }
    fun addAll(arrayList: LinkedHashSet<String>){
        lineList.addAll(arrayList)
    }
}