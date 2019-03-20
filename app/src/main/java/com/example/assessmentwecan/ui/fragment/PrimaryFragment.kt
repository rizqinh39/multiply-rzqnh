package com.example.assessmentwecan.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.example.assessmentwecan.R
import com.example.assessmentwecan.ui.interactor.PrimaryPresenterImpl
import com.example.assessmentwecan.ui.presenter.PrimaryPresenter
import com.example.assessmentwecan.ui.view.PrimaryView
import kotlinx.android.synthetic.main.fragment_primary.*
import kotlinx.android.synthetic.main.include_toolbar.*

class PrimaryFragment: BaseFragment(), PrimaryView {


    private var mPresenter: PrimaryPresenter? = null
    private var sumResult: Int? = 0

    companion object {
        @JvmStatic
        val TAG = PrimaryFragment::class.java.simpleName

        @JvmStatic
        fun newInstance(): PrimaryFragment {
            val fragment = PrimaryFragment()
            return fragment
        }
    }

    override val layoutResID: Int
        get() = R.layout.fragment_primary

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInstance()
    }

    private fun initInstance() {
        mPresenter = PrimaryPresenterImpl(context!!, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        setToolbar(R.id.toolbar, "Primary Number", true)
        toolbar.setNavigationOnClickListener { fragmentManager?.popBackStack() }
        btn_primary_result.setOnClickListener { findPrimary(et_primary_value.text.toString()) }
    }

    private fun findPrimary(primary: String) {
        var number = 0
        if (primary.isEmpty()){
            number = 0
        }else{
            number = primary.toInt()
        }
        mPresenter?.findPrimaryNumber(number)
    }

    override fun primaryFound(listPrimary: ArrayList<Int>?) {
        tv_primary_result.text =  TextUtils.join(", ", listPrimary);
    }
}