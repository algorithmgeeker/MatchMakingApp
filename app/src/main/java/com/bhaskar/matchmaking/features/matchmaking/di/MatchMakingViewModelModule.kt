package com.bhaskar.matchmaking.features.matchmaking.di

import androidx.lifecycle.ViewModel
import com.bhaskar.matchmaking.di.annotations.ActivityScope
import com.bhaskar.matchmaking.features.matchmaking.ui.viewmodel.MatchMakingViewModel
import com.bhaskar.matchmaking.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MatchMakingViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MatchMakingViewModel::class)
    @ActivityScope
    abstract fun bindMatchMakingViewModel(mapMatchMakingViewModel : MatchMakingViewModel): ViewModel
}