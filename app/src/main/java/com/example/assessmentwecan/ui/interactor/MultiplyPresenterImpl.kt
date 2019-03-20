package com.example.assessmentwecan.ui.interactor

import android.content.Context
import com.example.assessmentwecan.ui.presenter.MultiplyPresenter
import com.example.assessmentwecan.ui.view.MultiplyView

class MultiplyPresenterImpl(context: Context, view: MultiplyView): MultiplyPresenter {
    override fun multiplyValue(val1: Int, val2: Int) {
        mView.multiplyResult(val1*val2)
    }

    private var mContext: Context = context
    private var mView: MultiplyView = view

    companion object {
        @JvmStatic
        val TAG: String = MultiplyPresenterImpl::class.java.simpleName
    }
}