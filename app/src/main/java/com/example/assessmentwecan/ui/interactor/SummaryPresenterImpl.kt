package com.example.assessmentwecan.ui.interactor

import android.content.Context
import com.example.assessmentwecan.ui.presenter.SummaryPresenter
import com.example.assessmentwecan.ui.view.SummaryView

class SummaryPresenterImpl(context: Context, view: SummaryView): SummaryPresenter {


    private var mContext: Context = context
    private var mView: SummaryView = view

    companion object {
        @JvmStatic
        val TAG: String = SummaryPresenterImpl::class.java.simpleName
    }

    override fun sumValue(val1: Int, val2: Int) {
        mView.sumValueResult(val1.plus(val2))
    }
}