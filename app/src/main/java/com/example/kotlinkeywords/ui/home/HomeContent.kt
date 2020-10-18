package com.example.kotlinkeywords.ui.home

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.kotlinkeywords.R
import com.example.kotlinkeywords.data.Keyword
import com.example.kotlinkeywords.data.dummyKeywords
import com.example.kotlinkeywords.ui.KotlinKeywordsTheme
import kotlinx.coroutines.launch

@Composable
fun HomeContent(keywords: List<Keyword>, title: String, navigate: () -> Unit = {}) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = { Text(text = title) }) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = stringResource(R.string.add_keyword)) },
                icon = { Icon(Icons.Filled.Add) },
                backgroundColor = MaterialTheme.colors.primary,
                onClick = navigate
            )
        }
    ) {
        LazyKeywordList(keywords = keywords, scaffoldState)
    }
}

@Composable
fun LazyKeywordList(keywords: List<Keyword>, scaffoldState: ScaffoldState? = null) {
    LazyColumnFor(items = keywords, horizontalAlignment = Alignment.CenterHorizontally) { keyword ->
        KeywordCard(keyword = keyword, scaffoldState)
    }
}

@Composable
fun KeywordCard(keyword: Keyword, scaffoldState: ScaffoldState?) {
    val scope = rememberCoroutineScope()
    Surface(
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).wrapContentHeight()
            .fillMaxWidth()
            .clickable(onClick = {
                scope.launch {
                    scaffoldState?.snackbarHostState?.showSnackbar("${keyword.name} was tapped")
                }
            })
    ) {
        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)) {
            Text(
                text = keyword.name,
                style = TextStyle.Default.copy(fontSize = 48.sp, fontWeight = FontWeight.Bold)
            )
            Text(
                text = keyword.description,
                style = TextStyle.Default.copy(fontSize = 20.sp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewKeywordCard() {
    KotlinKeywordsTheme {
        KeywordCard(keyword = Keyword("if", "conditional statement"), rememberScaffoldState())
    }
}

@Preview
@Composable
fun PreviewLazyKeywordList() {
    KotlinKeywordsTheme {
        LazyKeywordList(keywords = dummyKeywords)
    }
}

@Preview
@Composable
fun PreviewHomeContent() {
    KotlinKeywordsTheme {
        HomeContent(keywords = dummyKeywords, title = "Home")
    }
}