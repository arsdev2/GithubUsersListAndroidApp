package com.example.githubusersviewer

import android.app.Application
import com.example.githubusersviewer.di.appModule
import com.example.githubusersviewer.user.list.data.di.githubUserListDataModule
import com.example.githubusersviewer.user.list.domain.di.githubUserListDomainModule
import com.example.githubusersviewer.user.list.view.di.githubUserListPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(
                appModule,
                githubUserListPresentationModule,
                githubUserListDomainModule,
                githubUserListDataModule
            ))
        }
    }

}