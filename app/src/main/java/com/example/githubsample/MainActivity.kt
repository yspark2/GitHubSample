package com.example.githubsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.githubsample.databinding.ActivityMainBinding
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
	val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		binding.btnStart.setOnClickListener {
			val intent = Intent(this, SubActivity::class.java)
			intent.putExtra("tag1", "박 용 석")
			intent.putExtra("tag2", 911008)
			startActivity(intent)
		}
		binding.btnTime.setOnClickListener {
			val date = System.currentTimeMillis()
			val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
			val formatTime = sdf.format(date)
			Toast.makeText(this, "현재시간은 ${formatTime} 입니다.", Toast.LENGTH_SHORT).show()
		}
	}
}