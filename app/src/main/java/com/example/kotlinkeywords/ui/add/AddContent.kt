package com.example.kotlinkeywords.ui.add

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview
import com.example.kotlinkeywords.data.Keyword
import com.example.kotlinkeywords.ui.KotlinKeywordsTheme
import com.example.kotlinkeywords.utility.Injector
import com.example.kotlinkeywords.viewmodel.KeywordViewModel

@Composable
fun AddContent(title: String, navigate: () -> Unit) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState, topBar = {
        TopAppBar(title = { Text(text = title) }, navigationIcon = {
            IconButton(onClick = navigate, icon = { Icon(Icons.Default.ArrowBack) })
        })
    }) {
        AddBody(navigate = navigate)
    }
}

@Composable
fun AddBody(navigate: () -> Unit) {
    val keywordText = remember { mutableStateOf(TextFieldValue()) }
    val isValidKeyword = remember { mutableStateOf(true) }
    val descriptionText = remember { mutableStateOf(TextFieldValue()) }
    val viewModel: KeywordViewModel = viewModel(
        factory = Injector.provideKeywordViewModelFactory(ContextAmbient.current)
    )
    Column(
        modifier = Modifier.padding(16.dp).wrapContentSize()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            value = keywordText.value,
            onValueChange = {
                keywordText.value = it
                if (keywordText.value.text.count() > 0) isValidKeyword.value = true
            },
            label = {
                val label = if (isValidKeyword.value) "Keyword" else "Enter valid keyword"
                Text(text = label)
            },
            placeholder = { Text(text = "Enter any keyword") },
            leadingIcon = { Icon(Icons.Default.Star) },
            isErrorValue = !isValidKeyword.value
        )
        TextField(
            modifier = Modifier.fillMaxWidth().preferredHeight(100.dp).padding(bottom = 16.dp),
            value = descriptionText.value,
            onValueChange = { descriptionText.value = it },
            label = { Text(text = "Keyword description") },
            placeholder = { Text(text = "Enter the description") }
        )
        Button(
            onClick = {
                isValidKeyword.value = keywordText.value.text.count() > 0
                if (isValidKeyword.value) {
                    viewModel.insert(
                        Keyword(
                            name = keywordText.value.text,
                            description = if (descriptionText.value.text.isEmpty()) "No Description" else descriptionText.value.text
                        )
                    )
                    navigate()
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Icon(Icons.Default.Send)
            Text(text = "Save", modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun PreviewAddBody() {
    KotlinKeywordsTheme {
        AddBody {}
    }
}

@Preview
@Composable
fun PreviewAddContent() {
    KotlinKeywordsTheme {
        AddContent(title = "Add", navigate = {})
    }
}