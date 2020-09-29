package com.example.kotlinkeywords.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlinkeywords.ui.KotlinKeywordsTheme

class AddFragment : Fragment() {
    private val args: AddFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                KotlinKeywordsTheme {
                    AddContent(title = args.title) { navigateToHome() }
                }
            }
        }
    }

    private fun navigateToHome() {
        findNavController().navigate(AddFragmentDirections.actionNavigationAddToNavigationHome())
    }
}