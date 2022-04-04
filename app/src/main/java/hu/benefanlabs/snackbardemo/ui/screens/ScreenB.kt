package hu.benefanlabs.snackbardemo.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import hu.benefanlabs.snackbardemo.ui.components.CustomSnackbarType
import hu.benefanlabs.snackbardemo.ui.navigation.NavigationRoutes

@Composable
fun ScreenB(
    showSnackbar: (String, SnackbarDuration, CustomSnackbarType) -> Unit,
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(modifier = Modifier.align(Alignment.TopCenter), text = "Current screen: B")
        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = {
                showSnackbar("Hello Snackbar", SnackbarDuration.Short, CustomSnackbarType.ERROR)
                navController.navigate(NavigationRoutes.ScreenA.route)
            }
        ) {
            Text("Navigate to ScreenA")
        }
    }
}