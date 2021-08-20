package com.example.githubsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsample.databinding.ActivityTotalMenuBinding
import com.example.githubsample.databinding.ItemRecyclerBinding

class TotalMenu : AppCompatActivity() {
	val binding by lazy { ActivityTotalMenuBinding.inflate(layoutInflater) }
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		val data = loadDate()
		val adapter = CustomAdapter(data)
		binding.recyclerView.adapter = adapter
		binding.recyclerView.layoutManager = LinearLayoutManager(this)

	}
	fun loadDate() : MutableList<Memo>{
		val TMList = mutableListOf<Memo>()
		for(no in 1..6){
			when(no){
				1 -> {
					val title = "독서"
					val memo  = Memo(no,title)
					TMList.add(memo)
				}
				2 -> {
					val title = "퀴즈"
					val memo  = Memo(no,title)
					TMList.add(memo)
				}
				3 -> {
					val title = "영어공부"
					val memo  = Memo(no,title)
					TMList.add(memo)
				}
				4 -> {
					val title = "계산기"
					val memo  = Memo(no,title)
					TMList.add(memo)
				}
				5 -> {
					val title = "음악감상"
					val memo  = Memo(no,title)
					TMList.add(memo)
				}
				6 -> {
					val title = "사진촬영"
					val memo  = Memo(no,title)
					TMList.add(memo)
				}
				7 -> {
					val title = "내 위치 확인"
					val memo  = Memo(no,title)
					TMList.add(memo)
				}
			}
		}
		return TMList
	}
}

class CustomAdapter(val dataList : MutableList<Memo>): RecyclerView.Adapter<CustomAdapter.Holder>(){
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
		val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return Holder(binding)
	}
	override fun getItemCount() = dataList.size
	override fun onBindViewHolder(holder: Holder, position: Int) {
		val memo = dataList.get(position)
		holder.setMemo(memo)
	}

	class Holder(val binding: ItemRecyclerBinding):  RecyclerView.ViewHolder(binding.root){
		lateinit var currentMemo : Memo
		init {
			binding.root.setOnClickListener {
				Toast.makeText(binding.root.context, " ${currentMemo.no} \n " +
						"${currentMemo.title}을 클릭하셨습니다.", Toast.LENGTH_SHORT).show()
			}
		}
		fun setMemo(memo: Memo){
			currentMemo = memo
			with(binding){
				textNo.text = "${memo.no}"
				textTitle.text = "${memo.title}"
			}
		}
	}
}