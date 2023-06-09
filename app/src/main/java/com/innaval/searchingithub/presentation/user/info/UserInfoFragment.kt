package com.innaval.searchingithub.presentation.user.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.innaval.searchingithub.R
import com.innaval.searchingithub.core.utils.Status
import com.innaval.searchingithub.databinding.FragmentUserInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserInfoFragment : Fragment() {

    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UserInfoViewModel by viewModel()

    private var adapter = UserInfoAdapter()

    private val args: UserInfoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return FragmentUserInfoBinding.inflate(inflater).also {
            _binding = it
            it.lifecycleOwner = viewLifecycleOwner
            it.viewModel = viewModel
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar()
        setRecyclerView()
        initListeners()
        initObservers()
        viewModel.getUser(args.userModel!!.login)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun setToolbar() {
        binding.toolbar.apply {
            title = getString(R.string.title_toolbar_details)
            setNavigationOnClickListener {
                activity?.onBackPressedDispatcher?.onBackPressed()
            }
        }
    }

    private fun setRecyclerView() {
        adapter.submitList(emptyList())
        binding.recyclerViewUserRepos.also {
            it.setHasFixedSize(true)
            it.adapter = adapter
        }
    }

    private fun initObservers() {
        viewModel.loadingStatus.observe(viewLifecycleOwner) {
            binding.swipeRefreshDetails.isRefreshing = false
            binding.viewFlipperAll.displayedChild =
                when (it) {
                    Status.LOADING -> 0
                    Status.SUCCESS -> 1
                    Status.ERROR -> 2
                    else -> 2
                }
        }

        viewModel.userInfo.observe(viewLifecycleOwner) { repos ->
            binding.viewFlipperUserRepos.displayedChild =
                if (repos != null && repos.isNotEmpty()) 0 else 1
            adapter.submitList(repos)
        }
    }
    private fun initListeners() {
        binding.swipeRefreshDetails.setOnRefreshListener {
            binding.swipeRefreshDetails.isRefreshing = true
            viewModel.getUser(args.userModel!!.login)
        }
    }
}