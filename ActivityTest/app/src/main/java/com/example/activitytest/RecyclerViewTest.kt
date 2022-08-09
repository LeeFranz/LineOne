package com.example.activitytest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view.*

class RecyclerViewTest : BaseActivity() {

    private val junkFoodList = ArrayList<JunkFood>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)
        initFood() // 初始化水果数据
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = JunkFoodAdapter2(junkFoodList)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun initFood() {
        repeat(2) {
            junkFoodList.add(JunkFood("bangbangtang", R.drawable.bangbangtang))
            junkFoodList.add(JunkFood("baomihua", R.drawable.baomihua))
            junkFoodList.add(JunkFood("hanbao", R.drawable.hanbao))
            junkFoodList.add(JunkFood("huafubing", R.drawable.huafubing))
            junkFoodList.add(JunkFood("kafei", R.drawable.kafei))
            junkFoodList.add(JunkFood("kele", R.drawable.kele))
            junkFoodList.add(JunkFood("makalong", R.drawable.makalong))
            junkFoodList.add(JunkFood("nailao", R.drawable.nailao))
            junkFoodList.add(JunkFood("paomian", R.drawable.paomian))
            junkFoodList.add(JunkFood("regou", R.drawable.regou))
            junkFoodList.add(JunkFood("shupian", R.drawable.shupian))
            junkFoodList.add(JunkFood("shutiao", R.drawable.shutiao))
            junkFoodList.add(JunkFood("tianfuluo", R.drawable.tianfuluo))
            junkFoodList.add(JunkFood("tiantianquan", R.drawable.tiantianquan))
            junkFoodList.add(JunkFood("tiantong", R.drawable.tiantong))
            junkFoodList.add(JunkFood("xiezaishousi", R.drawable.xiezaishousi))
            junkFoodList.add(JunkFood("xuegao", R.drawable.xuegao))
            junkFoodList.add(JunkFood("zhenzhunaicha", R.drawable.zhenzhunaicha))
        }
    }
}

class JunkFoodAdapter2(val junkFoodList: List<JunkFood>) :
    RecyclerView.Adapter<JunkFoodAdapter2.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val junkFoodImage: ImageView = view.findViewById(R.id.foodImage)
        val junkFoodName: TextView = view.findViewById(R.id.foodName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.junk_food_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val food = junkFoodList[position]
            Toast.makeText(parent.context, "click food ${food.name}", Toast.LENGTH_SHORT).show()
        }
        viewHolder.junkFoodImage.setOnClickListener {
            val position = viewHolder.adapterPosition
            val food = junkFoodList[position]
            Toast.makeText(
                parent.context, "you clicked image ${food.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = junkFoodList[position]
        holder.junkFoodImage.setImageResource(fruit.imgId)
        holder.junkFoodName.text = fruit.name
    }

    override fun getItemCount() = junkFoodList.size
}