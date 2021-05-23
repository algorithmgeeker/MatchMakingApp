package com.bhaskar.matchmaking.di.components

import android.app.Application
import com.bhaskar.matchmaking.base.BaseApplication
import com.bhaskar.matchmaking.di.annotations.AppScope
import com.bhaskar.matchmaking.di.modules.ActivityBuilderModule
import com.bhaskar.matchmaking.di.modules.ApplicationModule
import com.bhaskar.matchmaking.di.modules.NetworkModule
import com.bhaskar.matchmaking.di.modules.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@AppScope
@Component(
    modules = [AndroidSupportInjectionModule::class,
        NetworkModule::class,
        ApplicationModule::class,
        ViewModelFactoryModule::class,
        ActivityBuilderModule::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
