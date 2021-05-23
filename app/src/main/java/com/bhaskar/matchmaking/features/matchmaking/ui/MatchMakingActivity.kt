package com.bhaskar.matchmaking.features.matchmaking.ui

import android.content.SharedPreferences
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bhaskar.matchmaking.R
import com.bhaskar.matchmaking.base.BaseActivity
import com.bhaskar.matchmaking.constants.NavigationConstants
import com.bhaskar.matchmaking.constants.PrefConstants
import com.bhaskar.matchmaking.databinding.ActivityMatchMakingBinding
import com.bhaskar.matchmaking.features.matchmaking.ui.viewmodel.MatchMakingViewModel
import com.bhaskar.matchmaking.utils.displayAlertDialog
import javax.inject.Inject

/**
 * Activity Which will show the matchings
 */
class MatchMakingActivity : BaseActivity() {
    @Inject lateinit var preferences: SharedPreferences
    lateinit var vm : MatchMakingViewModel
    lateinit var binding : ActivityMatchMakingBinding


    override fun initViewModel() {
        vm = getViewModel(MatchMakingViewModel::class.java) as MatchMakingViewModel
    }

    override fun initViewBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_match_making)
        binding.vm = vm
        binding.executePendingBindings()
    }

    override fun onCreated() {
        vm.fetchUserData()
        if(preferences.getBoolean(PrefConstants.WELCOME, true)) {
            displayAlertDialog("Welcome", getString(R.string.welcome), this)
            preferences.edit().putBoolean(PrefConstants.WELCOME, false).apply()
        }

    }

    override fun initViewState() {
        liveData.observe(this) {
            if(it.what == NavigationConstants.SHOW_TOAST_MSG)
                showToast(it.obj as String)
        }

        vm.getUserData().observe(this) {
            vm.setUserData(it)
        }
    }
}