package com.dicoding.chelseaicon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.chelseaicon.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Player Details"

        val player = intent.getParcelableExtra<Players>("PLAYER")

        player?.let {
            with(binding) {
                Glide.with(this@DetailActivity)
                    .load(it.photo)
                    .into(imgPlayerPhoto)

                tvPlayerName.text = it.name
                tvNationality.text = it.nationality
                tvPosition.text = it.position
                tvMarketValue.text = it.marketValue
                tvPlayerCareer.text = it.career

                actionShare.setOnClickListener { _ ->
                    val shareIntent = Intent().apply {
                        action = Intent.ACTION_SEND
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, "Check out this player:\nname: ${it.name}\nNationality: ${it.nationality}\nPosition: ${it.position}\nMarketValue: ${it.marketValue}\nCareer: ${it.career}")
                    }
                    startActivity(Intent.createChooser(shareIntent, "Share via"))
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}