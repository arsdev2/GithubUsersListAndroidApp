package com.example.githubusersviewer.view.utils

import android.content.Context
import android.view.ContextThemeWrapper
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner


fun Context.getFragmentActivity(): FragmentActivity {
    return when (this) {
        is FragmentActivity -> this
        is ContextThemeWrapper -> this.baseContext as FragmentActivity
        else -> (this as ContextThemeWrapper).baseContext as FragmentActivity
    }
}

fun Context.getLifecycleOwner(): LifecycleOwner {
    return getFragmentActivity()
}

fun Context.getLifecycle(): Lifecycle {
    return getLifecycleOwner().lifecycle
}
