package com.example.myapplication.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodel.ActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ActivityViewModel
    lateinit var mainDataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainDataBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ActivityViewModel::class.java)
        mainDataBinding.viewmodel = viewModel
        my_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                this@MainActivity, LinearLayoutManager.VERTICAL,
                false
            )
        }

    }


}
