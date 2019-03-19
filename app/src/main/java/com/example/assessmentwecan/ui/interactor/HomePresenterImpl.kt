package com.example.assessmentwecan.ui.interactor

import android.content.Context
import com.example.assessmentwecan.R
import com.example.assessmentwecan.helper.MenuModel
import com.example.assessmentwecan.ui.presenter.HomePresenter
import com.example.assessmentwecan.ui.view.HomeView

class HomePresenterImpl(context: Context, view: HomeView): HomePresenter {

    private var mContext: Context = context
    private var mView: HomeView = view
    private var menuHome: ArrayList<MenuModel>? = ArrayList()

    companion object {
        @JvmStatic
        val TAG: String = HomePresenterImpl::class.java.simpleName
    }


    override fun getMenuData() {
        val getImage = mContext.resources.obtainTypedArray(R.array.home_menu_icon)
        val getTitle = mContext.resources.obtainTypedArray(R.array.home_menu_title)
         for (i in 0 until getImage.length()) {
             val model = MenuModel()
             model.imageItem = getImage.getDrawable(i)
             model.title = getTitle.getString(i)
             menuHome!!.add(model)
         }
        getImage.recycle()
        getTitle.recycle()
        mView.addMenuHome(menuHome)
    }

}