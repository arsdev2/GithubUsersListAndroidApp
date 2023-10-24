package com.example.githubusersviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.githubusersviewer.databinding.ActivityMainBinding
import com.example.githubusersviewer.user.list.view.GithubUserListFragment

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.toolbar.title = getString(R.string.list_users_title)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.githubUserListFragment.id, GithubUserListFragment::class.java, null)
        transaction.commitNow()
    }
}