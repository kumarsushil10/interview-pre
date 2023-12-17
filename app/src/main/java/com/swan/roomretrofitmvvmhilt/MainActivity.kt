package com.swan.roomretrofitmvvmhilt

import android.net.ConnectivityManager
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.swan.roomretrofitmvvmhilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.refreshBtn.setOnClickListener {
            if (isNetworkConnected()){
                viewModel.getProduct()
            }else{
                Toast.makeText(this,"Please connect to internet",Toast.LENGTH_LONG).show()
            }
        }
        viewModel.productList.observe(this, Observer {
            viewModel.addAllData(it.body()!!)
        })

        viewModel.getAllData.observe(this,Observer{
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = ProductListAdapter(it)
            if (it.size != 0){
                binding.refreshBtn.visibility = View.GONE
            }else{
                binding.refreshBtn.visibility = View.VISIBLE
            }
        })

    }
    private fun isNetworkConnected(): Boolean {
        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }
}