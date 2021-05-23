package com.bhaskar.matchmaking.base

import android.app.Application
import android.util.Log
import android.widget.Toast
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import java.io.IOException
import java.net.SocketException
import javax.inject.Inject

open class BaseRepository @Inject constructor() {
    private val compositeDisposable = CompositeDisposable()

    fun dispose() {
        if (compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
            compositeDisposable.clear()
        }
    }

    protected open fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}