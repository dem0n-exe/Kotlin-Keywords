package com.example.kotlinkeywords.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlinkeywords.data.dummyKeywords
import com.example.kotlinkeywords.ui.KotlinKeywordsTheme

class HomeFragment : Fragment() {
    private val args: HomeFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                KotlinKeywordsTheme {
                    HomeContent(
                        keywords = dummyKeywords,
                        title = args.title,
                    ) { navigateToAddFragment() }
                }
            }
        }
    }

    private fun navigateToAddFragment() {
        findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToNavigationAdd())
    }
}