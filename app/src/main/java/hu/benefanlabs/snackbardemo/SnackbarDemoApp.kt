package hu.benefanlabs.snackbardemo

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import hu.benefanlabs.snackbardemo.ui.navigation.MyNavigation
import hu.benefanlabs.snackbardemo.ui.theme.SnackbarDemoTheme

@Composable
fun SnackbarDemoApp() {
    SnackbarDemoTheme {
        val appState: SnackbarDemoAppState = rememberSnackbarDemoAppState()

        Scaffold(
            scaffoldState = appState.scaffoldState
        ) {
            MyNavigation(
                navController = appState.navController,
                showSnackbar = { message, duration ->
                    appState.showSnackbar(message = message, duration = duration)
                }
            )
        }
    }
}