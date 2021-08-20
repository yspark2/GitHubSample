package com.example.githubsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.githubsample.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
	val binding by lazy { ActivitySubBinding.inflate(layoutInflater) }
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		binding.to1.text = intent.getStringExtra("tag1")
		binding.to2.text = "${intent.getIntExtra("tag2", 0)}"

		binding.btnClose.setOnClickListener {
			val returnIntent = Intent()
			val message = binding.editText.toString()
			Toast.makeText(this, "입력된 메세지는 ${binding.editText.text} 입니다.", Toast.LENGTH_SHORT).show()
			returnIntent.putExtra("returnValue", message)
			setResult(RESULT_OK, returnIntent)
			finish()
		}
	}
}