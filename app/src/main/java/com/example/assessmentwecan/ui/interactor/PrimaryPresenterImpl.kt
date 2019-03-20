package com.example.assessmentwecan.ui.interactor

import android.content.Context
import com.example.assessmentwecan.ui.presenter.PrimaryPresenter
import com.example.assessmentwecan.ui.view.PrimaryView

class PrimaryPresenterImpl (context: Context, view: PrimaryView): PrimaryPresenter {


    private var mContext: Context = context
    private var mView: PrimaryView = view
    private var listPrimary: ArrayList<Int>? = ArrayList()

    companion object {
        @JvmStatic
        val TAG: String = PrimaryPresenterImpl::class.java.simpleName
    }

    override fun findPrimaryNumber(number: Int) {

        for (n in 1 until number) {
            var prime = true
            // analyzes if n is prime

            for (j in 2 until n) {
                if (n % j == 0) {
                    prime = false
                    break // exit the inner for loop
                }
            }
            if (prime && n != 1) {
                listPrimary?.add(n)
            }
        }
        mView?.primaryFound(listPrimary)
    }
}