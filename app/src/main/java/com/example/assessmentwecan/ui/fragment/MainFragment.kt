package com.example.assessmentwecan.ui.fragment

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.assessmentwecan.R
import com.example.assessmentwecan.helper.CommonUtil
import com.example.assessmentwecan.helper.MenuModel
import com.example.assessmentwecan.helper.listener.RecyclerOnClickListener
import com.example.assessmentwecan.ui.adapter.HomeMenuAdapter
import com.example.assessmentwecan.ui.interactor.HomePresenterImpl
import com.example.assessmentwecan.ui.presenter.HomePresenter
import com.example.assessmentwecan.ui.view.HomeView
import com.example.assessmentwecan.ui.widgets.GridSpacingItemDecorationkt
import kotlinx.android.synthetic.main.fragment_home.*

class MainFragment : BaseFragment(), HomeView, RecyclerOnClickListener {


    private var mPresenter: HomePresenter? = null
    private var mMenuHome: ArrayList<MenuModel>? = null
    private var mAdapter: HomeMenuAdapter? = null

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
        mMenuHome = ArrayList()
        mPresenter = HomePresenterImpl(context!!, this)
        mAdapter = HomeMenuAdapter(context!!, mMenuHome!!)
        mAdapter?.setOnClickListener(this)
    }

    override fun onClick(view: View, position: Int) {
        when (position) {
            0 -> {
                replaceFragment(false, R.id.container_home, SummaryFragment.newInstance(), SummaryFragment.TAG)
            }
            1 -> {
                replaceFragment(false, R.id.container_home, MultiplyFragment.newInstance(), MultiplyFragment.TAG)
            }
            2 -> {
                replaceFragment(false, R.id.container_home, PrimaryFragment.newInstance(), PrimaryFragment.TAG)
            }
            3 -> {
                replaceFragment(false, R.id.container_home, FibonacciFragment.newInstance(), FibonacciFragment.TAG)
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initMenu()
    }

    private fun initMenu() {
        if (mMenuHome!!.isNotEmpty()) {
            mMenuHome!!.clear()
        }
        mPresenter?.getMenuData()

    }

    private fun initView() {
        setToolbar(R.id.toolbar, "Home", false)
        setRecycleView()
    }

    private fun setRecycleView() {
        val spaceDecorator = GridSpacingItemDecorationkt(2, CommonUtil.dpToPx(context!!, 8), true, 2)
        rv_home!!.removeItemDecoration(spaceDecorator)
        rv_home!!.setHasFixedSize(true)
        rv_home.layoutManager = GridLayoutManager(context, 2)
        // recyclerView.addItemDecoration(spaceDecorator!!)
        rv_home.itemAnimator = DefaultItemAnimator()
        rv_home.isNestedScrollingEnabled = false
        rv_home.isFocusable = false
        rv_home.adapter = mAdapter
        rv_home.removeItemDecoration(spaceDecorator)
        if (rv_home.itemDecorationCount == 0) {
            rv_home.addItemDecoration(spaceDecorator)
        }
    }

    override fun addMenuHome(menuHome: ArrayList<MenuModel>?) {
        mMenuHome?.addAll(menuHome!!)
        mAdapter?.notifyDataSetChanged()

    }
}