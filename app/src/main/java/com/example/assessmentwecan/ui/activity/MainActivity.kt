package com.example.assessmentwecan.ui.activity

import android.os.Bundle
import com.example.assessmentwecan.R
import com.example.assessmentwecan.ui.fragment.MainFragment

class MainActivity : BaseActivity(){
    override val layoutResID: Int
        get() =R.layout.activity_main


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
       addFragment(R.id.container_home, MainFragment.newInstance(), MainFragment.TAG)
    }
}
