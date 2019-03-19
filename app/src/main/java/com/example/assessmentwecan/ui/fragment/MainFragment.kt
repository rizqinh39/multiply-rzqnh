package com.example.assessmentwecan.ui.fragment

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assessmentwecan.R
import com.example.assessmentwecan.helper.MenuModel
import com.example.assessmentwecan.helper.listener.RecyclerOnClickListener
import com.example.assessmentwecan.ui.adapter.HomeMenuAdapter
import com.example.assessmentwecan.ui.interactor.HomePresenterImpl
import com.example.assessmentwecan.ui.presenter.HomePresenter
import com.example.assessmentwecan.ui.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*

class MainFragment: BaseFragment(), HomeView, RecyclerOnClickListener {


    private var mPresenter: HomePresenter? = null
    private var mMenuHome: ArrayList<MenuModel>? = ArrayList()
    private var mAdapter: HomeMenuAdapter?= null

    companion object {
        @JvmStatic
        val TAG = MainFragment::class.java.simpleName

        @JvmStatic
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }

    override val layoutResID: Int
        get() = R.layout.fragment_home


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInstance()
    }

    private fun initInstance() {
        mPresenter = HomePresenterImpl(context!!, this)
        mAdapter = HomeMenuAdapter(context!!, mMenuHome!!)
        mAdapter?.setOnClickListener(this)
    }

    override fun onClick(view: View, position: Int) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMenu()
        initView()
    }

    private fun initMenu() {
        mPresenter?.getMenuData()
    }

    private fun initView() {
        setToolbar(R.id.toolbar, "Home", false)
        setRecycleView()
    }

    private fun setRecycleView() {
        // spaceDecorator = GridSpacingItemDecorationkt(3, ConvertUtil.dpToPx(context, 8), true, 0)
        // recyclerView!!.removeItemDecoration(spaceDecorator!!)
        rv_home!!.setHasFixedSize(true)
        rv_home.layoutManager = GridLayoutManager(context, 3)
        // recyclerView.addItemDecoration(spaceDecorator!!)
        rv_home.itemAnimator = DefaultItemAnimator()
        rv_home.isNestedScrollingEnabled = false
        rv_home.isFocusable = false
        rv_home.adapter = mAdapter
        /*recyclerView.removeItemDecoration(spaceDecorator!!)
        if (recyclerView.itemDecorationCount == 0) {
            recyclerView.addItemDecoration(spaceDecorator!!)
        }*/
    }

    override fun addMenuHome(menuHome: ArrayList<MenuModel>?) {
        mMenuHome = menuHome
        mAdapter?.notifyDataSetChanged()

    }
}