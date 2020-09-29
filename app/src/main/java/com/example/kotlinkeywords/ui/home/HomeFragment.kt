package com.example.kotlinkeywords.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.ui.tooling.preview.Preview
import com.example.kotlinkeywords.ui.KotlinKeywordsTheme

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                KotlinKeywordsTheme {
                    Hello(text = "World!")
                }
            }
        }
    }
}

@Composable
fun Hello(text: String) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hello $text",
            modifier = Modifier.wrapContentSize(Alignment.Center),
            style = TextStyle.Default.copy(fontSize = 55.sp)
        )
    }
}

@Preview
@Composable
fun previewHello() {
    Hello(text = "Android")
}