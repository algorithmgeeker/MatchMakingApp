package com.bhaskar.matchmaking.di.modules

import com.bhaskar.matchmaking.di.annotations.ActivityScope
import com.bhaskar.matchmaking.features.matchmaking.di.MatchMakingModule
import com.bhaskar.matchmaking.features.matchmaking.ui.MatchMakingActivity
import com.bhaskar.matchmaking.features.matchmaking.di.MatchMakingViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [MatchMakingViewModelModule::class, MatchMakingModule::class])
    @ActivityScope
    abstract fun contributeMatchMakingActivity(): MatchMakingActivity
}