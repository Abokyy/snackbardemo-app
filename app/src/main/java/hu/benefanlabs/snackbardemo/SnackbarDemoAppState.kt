package hu.benefanlabs.snackbardemo

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import hu.benefanlabs.snackbardemo.ui.components.CustomSnackbarState
import hu.benefanlabs.snackbardemo.ui.components.CustomSnackbarType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SnackbarDemoAppState(
    val customSnackbarState: CustomSnackbarState,
    val scaffoldState: ScaffoldState,
    val snackbarScope: CoroutineScope,
    val navController: NavHostController
) {
    fun showSnackbar(
        message: String,
        duration: SnackbarDuration = SnackbarDuration.Short,
        type: CustomSnackbarType
    ) {
        snackbarScope.launch {
            customSnackbarState.showSnackbar(
                message = message,
                duration = duration,
                type = type
            )
        }
    }
}

@Composable
fun rememberSnackbarDemoAppState(
    snackbarHostState: SnackbarHostState = remember {
        SnackbarHostState()
    },
    customSnackbarState: CustomSnackbarState = remember {
        CustomSnackbarState(
            snackbarHostState = snackbarHostState
        )
    },
    scaffoldState: ScaffoldState = rememberScaffoldState(
        snackbarHostState = snackbarHostState
    ),
    navController: NavHostController = rememberNavController(),
    snackbarScope: CoroutineScope = rememberCoroutineScope()
) = remember(customSnackbarState, scaffoldState, navController, snackbarScope) {
    SnackbarDemoAppState(
        customSnackbarState = customSnackbarState,
        scaffoldState = scaffoldState,
        navController = navController,
        snackbarScope = snackbarScope
    )
}