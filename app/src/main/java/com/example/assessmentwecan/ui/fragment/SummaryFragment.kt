package com.example.assessmentwecan.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.assessmentwecan.R
import com.example.assessmentwecan.ui.interactor.SummaryPresenterImpl
import com.example.assessmentwecan.ui.presenter.SummaryPresenter
import com.example.assessmentwecan.ui.view.SummaryView
import kotlinx.android.synthetic.main.fragment_summary.*
import kotlinx.android.synthetic.main.include_toolbar.*
import org.jetbrains.anko.design.snackbar

class SummaryFragment : BaseFragment(), SummaryView {

    private var mPresenter: SummaryPresenter? = null

    companion object {
        @JvmStatic
        val TAG = SummaryFragment::class.java.simpleName

        @JvmStatic
        fun newInstance(): SummaryFragment {
            val fragment = SummaryFragment()
            return fragment
        }
    }

    override val layoutResID: Int
        get() = R.layout.fragment_summary

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInstance()
    }

    private fun initInstance() {
        mPresenter = SummaryPresenterImpl(context!!, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        setToolbar(R.id.toolbar, "Summary", true)
        toolbar.setNavigationOnClickListener { fragmentManager?.popBackStack() }
        btn_sum_result.setOnClickListener {
            if (et_sum_one.text.toString().isEmpty() || et_sum_two.text.toString().isEmpty()) {
                view?.snackbar("Can't operate")
            } else {
                mPresenter?.sumValue(et_sum_one.text.toString().toInt(), et_sum_two.text.toString().toInt())
            }
        }

    }

    override fun sumValueResult(plus: Int) {
        tv_sum_result.text = plus.toString()
    }


}