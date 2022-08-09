package com.example.activitytest

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.list_view.*

class ListViewActivity : BaseActivity() {

    private val data = listOf(
        "Apple", "Banana", "Orange", "Watermelon",
        "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
        "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
        "Pineapple", "Strawberry", "Cherry", "Mango"
    )

    private val junkFoodList = ArrayList<JunkFood>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)
        initFood()
        val adapter = JunkFoodAdapter(this, R.layout.junk_food_item, junkFoodList)
        listView.adapter = adapter
        listView.setOnItemClickListener{
                _, _, position, _ ->
            val fruit = junkFoodList[position]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
        }
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


class JunkFoodAdapter(activity: Activity, val resourceId: Int, data: List<JunkFood>) :
    ArrayAdapter<JunkFood>(activity, resourceId, data) {

    inner class ViewHolder(val foodImage: ImageView, val foodName: TextView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val foodImage: ImageView = view.findViewById(R.id.foodImage)
            val foodName: TextView = view.findViewById(R.id.foodName)
            viewHolder = ViewHolder(foodImage, foodName)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        val junkFood = getItem(position) // 获取当前项的Fruit实例
        if (junkFood != null) {
            viewHolder.foodImage.setImageResource(junkFood.imgId)
            viewHolder.foodName.text = junkFood.name
        }
        return view
    }
}