package com.github.farzadfarazmand.kidzydemo.view.activtiy

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.farzadfarazmand.kidzydemo.R
import com.github.farzadfarazmand.kidzydemo.models.UserModel
import com.github.farzadfarazmand.kidzydemo.util.hide
import com.github.farzadfarazmand.kidzydemo.util.show
import com.github.farzadfarazmand.kidzydemo.view.adapter.UsersListAdapter
import com.github.farzadfarazmand.kidzydemo.viewmodel.UsersListViewModel
import com.github.farzadfarazmand.kidzydemo.viewmodel.common.Loading
import com.github.farzadfarazmand.kidzydemo.viewmodel.common.Success
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import kotlinx.android.synthetic.main.activity_users_list.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_users_list_loading.*
import javax.inject.Inject

class UsersListActivity : BaseActivity() {

    private val TAG = "UsersListActivity"

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val usersListViewModel: UsersListViewModel by viewModels { viewModelFactory }

    private lateinit var usersListAdapter: UsersListAdapter

    override fun setLayoutId(): Int = R.layout.activity_users_list

    override fun initComponents(savedInstanceState: Bundle?) {
        initToolbar()
        initUsersList()
        observeUserList()
        observeUiState()
        loadUsersList()
    }

    private fun initToolbar() {
        toolbarTitle.text = getString(R.string.users_list_toolbar_title)
        //left button
        toolbarLeftButton.setImageResource(R.drawable.ic_search)
        toolbarLeftButton.setOnClickListener {
            //TODO : implement search
        }

        //right button
        toolbarRightButton.setImageResource(R.drawable.ic_toolbar_bookmark)
        toolbarRightButton.setOnClickListener {
            //TODO : implement bookmark list
        }

    }

    private fun initUsersList() {
        val linearLayoutManager = LinearLayoutManager(this)
        usersList.layoutManager = linearLayoutManager
        usersList.setHasFixedSize(true)
        usersListAdapter = UsersListAdapter {
            //TODO show user detail activity
        }
        usersList.adapter = usersListAdapter

        usersList.addOnScrollListener(object :
            androidx.recyclerview.widget.RecyclerView.OnScrollListener() {
            override fun onScrolled(
                recyclerView: androidx.recyclerview.widget.RecyclerView,
                dx: Int,
                dy: Int
            ) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = linearLayoutManager.childCount
                val totalItemCount = linearLayoutManager.itemCount
                val pastVisibleItems = linearLayoutManager.findFirstVisibleItemPosition()
                if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                    Log.d(TAG, "End of the List")
                    loadUsersList()
                }
            }
        })

    }

    private fun loadUsersList() {
        usersListViewModel.loadUsers()
    }

    private fun observeUserList() {
        usersListViewModel.usersList.observe(this, {
            showResults(it)
        })
    }

    private fun showResults(users: List<UserModel>) {
        if (users.isNotEmpty()) {
            usersList.apply {
                adapter =
                    ScaleInAnimationAdapter(usersListAdapter.apply {
                        submitList(users)
                    })
            }
        } else {
            showNoUserView()
        }
    }

    private fun observeUiState() {
        usersListViewModel.uiState.observe(this, {
            when (it) {
                is Loading -> showLoading()
                is Success -> hideLoading()
                is Error -> showError(it)
            }
        })
    }


    private fun showLoading() {
        usersList.hide()
        usersListLoadingView.show()
        usersListLoadingView.showShimmer(true)
    }

    private fun hideLoading() {
        usersList.show()
        usersListLoadingView.hide()
        usersListLoadingView.stopShimmer()
    }

    private fun showError(error: Throwable) {

    }

    private fun showNoUserView() {

    }

}