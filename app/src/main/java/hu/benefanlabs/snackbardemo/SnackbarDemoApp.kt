package hu.benefanlabs.snackbardemo

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import hu.benefanlabs.snackbardemo.ui.components.CustomSnackbar
import hu.benefanlabs.snackbardemo.ui.navigation.MyNavigation
import hu.benefanlabs.snackbardemo.ui.theme.SnackbarDemoTheme

@Composable
fun SnackbarDemoApp() {
    SnackbarDemoTheme {
        val appState: SnackbarDemoAppState = rememberSnackbarDemoAppState()

        Scaffold(
            scaffoldState = appState.scaffoldState,
            snackbarHost = {
                CustomSnackbar(state = appState.customSnackbarState)
            }
        ) {
            MyNavigation(
                navController = appState.navController,
                showSnackbar = { message, duration, type ->
                    appState.showSnackbar(message = message, duration = duration, type = type)
                }
            )
        }
    }
}