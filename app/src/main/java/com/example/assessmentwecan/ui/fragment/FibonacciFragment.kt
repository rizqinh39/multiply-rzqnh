package com.example.assessmentwecan.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.example.assessmentwecan.R
import com.example.assessmentwecan.ui.interactor.FibonacciPresenterImpl
import com.example.assessmentwecan.ui.presenter.FibonacciPresenter
import com.example.assessmentwecan.ui.view.FibonacciView
import kotlinx.android.synthetic.main.fragment_fibonacci.*
import kotlinx.android.synthetic.main.include_toolbar.*

class FibonacciFragment: BaseFragment(), FibonacciView {


    private var mPresenter: FibonacciPresenter? = null

    override val layoutResID: Int
        get() = R.layout.fragment_fibonacci

    companion object {
        @JvmStatic
        val TAG = FibonacciFragment::class.java.simpleName

        @JvmStatic
        fun newInstance(): FibonacciFragment {
            val fragment = FibonacciFragment()
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInstance()
    }

    private fun initInstance() {
        mPresenter = FibonacciPresenterImpl(context!!, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        setToolbar(R.id.toolbar, "Primary Number", true)
        toolbar.setNavigationOnClickListener { fragmentManager?.popBackStack() }
        btn_fibo_result.setOnClickListener { findFibo(et_fibo_value.text.toString()) }
    }

    private fun findFibo(fibo: String) {
        var number = 0
        if (fibo.isEmpty()){
            number = 0
        }else{
            number = fibo.toInt()
        }
        mPresenter?.findFiboNumber(number)
    }

    override fun fiboResult(listFibo: ArrayList<Int>?) {
        tv_fibo_result.text = TextUtils.join(", ", listFibo);
    }
}