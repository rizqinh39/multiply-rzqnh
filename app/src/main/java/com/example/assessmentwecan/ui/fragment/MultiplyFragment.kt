package com.example.assessmentwecan.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.assessmentwecan.R
import com.example.assessmentwecan.ui.interactor.MultiplyPresenterImpl
import com.example.assessmentwecan.ui.presenter.MultiplyPresenter
import com.example.assessmentwecan.ui.view.MultiplyView
import kotlinx.android.synthetic.main.fragment_multiply.*
import kotlinx.android.synthetic.main.include_toolbar.*
import org.jetbrains.anko.design.snackbar

class MultiplyFragment : BaseFragment(), MultiplyView {

    private var mPresenter: MultiplyPresenter? = null

    companion object {
        @JvmStatic
        val TAG = MultiplyFragment::class.java.simpleName

        @JvmStatic
        fun newInstance(): MultiplyFragment {
            val fragment = MultiplyFragment()
            return fragment
        }
    }


    override val layoutResID: Int
        get() = R.layout.fragment_multiply

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInstance()
    }

    private fun initInstance() {
        mPresenter = MultiplyPresenterImpl(context!!, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        setToolbar(R.id.toolbar, "Multiply", true)
        toolbar.setNavigationOnClickListener { fragmentManager?.popBackStack() }
        btn_multi_result.setOnClickListener {
            if (et_multi_one.text.toString().isEmpty() || et_multi_two.text.toString().isEmpty()) {
                view?.snackbar("Can't operate")
            } else {
                mPresenter?.multiplyValue(et_multi_one.text.toString().toInt(), et_multi_two.text.toString().toInt())
            }
        }
    }

    override fun multiplyResult(i: Int) {
        tv_multi_result.text = i.toString()
    }


}