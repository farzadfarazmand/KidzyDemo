package com.github.farzadfarazmand.kidzydemo.view.activtiy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.github.farzadfarazmand.kidzydemo.R
import com.github.farzadfarazmand.kidzydemo.databinding.ActivtyUserDetailBinding
import com.github.farzadfarazmand.kidzydemo.di.factory.UserDetailViewModelFactory
import com.github.farzadfarazmand.kidzydemo.models.UserModel
import com.github.farzadfarazmand.kidzydemo.util.hide
import com.github.farzadfarazmand.kidzydemo.util.loadImage
import com.github.farzadfarazmand.kidzydemo.viewmodel.UserDetailViewModel
import kotlinx.android.synthetic.main.layout_toolbar.*

class UserDetailActivity : AppCompatActivity() {

    companion object {
        private const val EXTRAS_USER_KEY = "UserDetail_User"

        fun lunchActivity(context: Context, user: UserModel) {
            val intent = Intent(context, UserDetailActivity::class.java)
            intent.putExtra(EXTRAS_USER_KEY, user)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivtyUserDetailBinding
    private lateinit var userDetailViewModel: UserDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_user_detail)

        binding = DataBindingUtil.setContentView(this, R.layout.activty_user_detail)

        handleIntent()
        initToolbar()
        initViews()
    }

    private fun handleIntent() {
        intent.extras?.let {
            val user = it.getSerializable(EXTRAS_USER_KEY) as UserModel
            val viewModelFactory = UserDetailViewModelFactory(user)
            userDetailViewModel =
                ViewModelProviders.of(this, viewModelFactory).get(UserDetailViewModel::class.java)
        } ?: kotlin.run {
            //TODO handle this
        }
    }

    private fun initToolbar() {
        toolbarTitle.text = userDetailViewModel.user.fullName
        //left button
        toolbarLeftButton.setImageResource(R.drawable.ic_left_arrow)
        toolbarLeftButton.setOnClickListener {
            finish()
        }

        //right button
        toolbarRightButton.hide()
    }

    private fun initViews() {
        binding.user = userDetailViewModel.user
        binding.executePendingBindings()
        binding.userAvatar.loadImage(userDetailViewModel.user.avatar)
        binding.btnSendEmail.setOnClickListener {
            startActivity(userDetailViewModel.createEmailIntent(getString(R.string.user_detail_email_subject)))
        }
    }


}