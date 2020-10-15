package com.github.farzadfarazmand.kidzydemo.view.activtiy

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.github.farzadfarazmand.kidzydemo.R
import com.github.farzadfarazmand.kidzydemo.databinding.ActivityUserDetailBinding
import com.github.farzadfarazmand.kidzydemo.models.UserModel
import com.github.farzadfarazmand.kidzydemo.util.hide
import com.github.farzadfarazmand.kidzydemo.util.loadImage
import com.github.farzadfarazmand.kidzydemo.viewmodel.UserDetailViewModel
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject

class UserDetailActivity : BaseActivity() {

    companion object {
        private const val EXTRAS_USER_KEY = "UserDetail_User"

        fun lunchActivity(
            context: Context,
            user: UserModel,
            transitionOption: ActivityOptionsCompat
        ) {
            val intent = Intent(context, UserDetailActivity::class.java)
            intent.putExtra(EXTRAS_USER_KEY, user)
            ActivityCompat.startActivity(context, intent, transitionOption.toBundle())
        }
    }

    private lateinit var binding: ActivityUserDetailBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val userDetailViewModel: UserDetailViewModel by viewModels { viewModelFactory }

    override fun setLayoutId(): Int = R.layout.activity_user_detail

    override fun initComponents(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        handleIntent()
        initToolbar()
        initViews()
    }

    private fun handleIntent() {
        intent.extras?.let {
            val user = it.getSerializable(EXTRAS_USER_KEY) as UserModel
            userDetailViewModel.user = user
            userDetailViewModel.setUserBookmarkedStatus()
        } ?: kotlin.run {
            Toast.makeText(this, getString(R.string.user_detail_intent_error), Toast.LENGTH_LONG)
                .show()
            finish()
        }
    }

    private fun initToolbar() {
        toolbarTitle.text = userDetailViewModel.user.getFullName()
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
        //show send email chooser
        binding.btnSendEmail.setOnClickListener {
            startActivity(userDetailViewModel.createEmailIntent(getString(R.string.user_detail_email_subject)))
        }

        //bookmark
        binding.btnBookmarkUser.setOnClickListener { userDetailViewModel.changeUserBookmarkedStatus() }
        userDetailViewModel.isBookmarked.observe(this) { isBookmarked ->
            if (isBookmarked) {
                changeBookmarkIconWithAnimation(binding.btnBookmarkUser)
            } else {
                binding.btnBookmarkUser.setImageResource(R.drawable.ic_bookmark_outline)
            }
        }
    }

    private fun changeBookmarkIconWithAnimation(icon: AppCompatImageView) {
        YoYo.with(Techniques.BounceIn).withListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                icon.setImageResource(R.drawable.ic_bookmark_fill)
            }
        }).duration(500).playOn(icon)
    }


}