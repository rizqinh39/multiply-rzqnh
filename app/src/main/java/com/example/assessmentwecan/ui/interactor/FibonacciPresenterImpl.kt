package com.example.assessmentwecan.ui.interactor

import android.content.Context
import com.example.assessmentwecan.ui.presenter.FibonacciPresenter
import com.example.assessmentwecan.ui.view.FibonacciView

class FibonacciPresenterImpl(context: Context, view: FibonacciView): FibonacciPresenter {



    private var mContext: Context = context
    private var mView: FibonacciView = view
    private var listFibo: ArrayList<Int>? = ArrayList()

    companion object {
        @JvmStatic
        val TAG: String = PrimaryPresenterImpl::class.java.simpleName
    }

    override fun findFiboNumber(number: Int) {
        var a = 0
        var b = 1
        var i: Int
        var c: Int

        i = 0
        while (i <= number) {
            if (i <= 1) {
                c = i
            } else {
                c = a + b
                a = b
                b = c
            }
            print(c)
            listFibo?.add(c)
            i++
        }
        mView.fiboResult(listFibo)
    }
}