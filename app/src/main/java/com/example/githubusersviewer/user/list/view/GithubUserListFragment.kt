package com.example.githubusersviewer.user.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusersviewer.databinding.FragmentGithubUserListBinding
import com.example.githubusersviewer.user.list.view.adapter.GithubUserListAdapter
import com.example.githubusersviewer.user.list.view.viewmodel.GithubUserListViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GithubUserListFragment : Fragment() {

    private lateinit var binding: FragmentGithubUserListBinding

    private val githubUserListAdapter: GithubUserListAdapter by inject { parametersOf(requireContext()) }
    private val githubUserListViewModel: GithubUserListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGithubUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.githubUsersList.apply {
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            adapter = githubUserListAdapter
        }
        githubUserListViewModel.githubUserGroupList.observe(viewLifecycleOwner) {
            githubUserListAdapter.updateData(it)
        }

    }
}