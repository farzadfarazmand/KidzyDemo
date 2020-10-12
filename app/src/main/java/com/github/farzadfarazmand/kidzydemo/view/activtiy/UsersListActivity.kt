package com.github.farzadfarazmand.kidzydemo.view.activtiy

import android.os.Bundle
import com.github.farzadfarazmand.kidzydemo.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class UsersListActivity : BaseActivity() {

    override fun setLayoutId(): Int = R.layout.activity_users_list

    override fun initComponents(savedInstanceState: Bundle?) {
        initToolbar()

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
            //TODO : implement search
        }

    }
}