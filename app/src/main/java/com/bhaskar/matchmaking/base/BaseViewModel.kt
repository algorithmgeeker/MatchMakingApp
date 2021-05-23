package com.bhaskar.matchmaking.base

import android.app.Application
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import java.io.IOException
import java.net.SocketException
import javax.inject.Inject

open class BaseViewModel @Inject constructor() : ViewModel(){
    @Inject
    protected lateinit var application: Application

    var isLoading = ObservableBoolean(false)

    protected var message = Message()

    @Inject
    protected lateinit var singleLiveEvent: SingleLiveEvent<Message>
}