package com.dicoding.chelseaicon

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.chelseaicon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Players>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPlayers.setHasFixedSize(true)

        list.addAll(getListPlayers())
        showRecyclerList()
    }

    private fun getListPlayers(): ArrayList<Players> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataNationality = resources.getStringArray(R.array.data_nationality)
        val dataPosition = resources.getStringArray(R.array.data_position)
        val dataMarketValue = resources.getStringArray(R.array.data_market_value)
        val dataCareer = resources.getStringArray(R.array.data_carrier)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listPlayers = ArrayList<Players>()
        for (i in dataName.indices) {
            val player = Players(dataName[i], dataNationality[i], dataPosition[i], dataMarketValue[i], dataCareer[i], dataPhoto[i])
            listPlayers.add(player)
        }
        return listPlayers
    }

    private fun showRecyclerList() {
        binding.rvPlayers.layoutManager = LinearLayoutManager(this)
        val listPlayersAdapter = ListPlayersAdapter(list)
        binding.rvPlayers.adapter = listPlayersAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_page, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val aboutPage = Intent(this@MainActivity, AboutPage::class.java)
                startActivity(aboutPage)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}