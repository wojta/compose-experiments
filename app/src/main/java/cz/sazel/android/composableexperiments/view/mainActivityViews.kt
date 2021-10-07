package cz.sazel.android.composableexperiments.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * Created on 07.10.21.
 */

@Composable
@Preview
fun MainActivityView(title: String = "App Name", content: @Composable (PaddingValues) -> Unit = { }) {
    val state = rememberScaffoldState()
    val composableScope = rememberCoroutineScope()
    suspend fun toggleDrawer() {
        if (state.drawerState.isOpen) {
            state.drawerState.close()
        } else state.drawerState.open()
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(title) }, navigationIcon = {
                IconButton(onClick = { composableScope.launch { toggleDrawer() } }) {
                    Icon(Icons.Filled.Menu, contentDescription = null)
                }
            })
        },
        drawerContent = { Drawer() },
        scaffoldState = state,
        content = content,
        backgroundColor = colors.background
    )
}

@Composable
@Preview(showBackground = true)
fun Drawer() {
    Text("Drawer title", modifier = Modifier.padding(16.dp))
    Divider()
}