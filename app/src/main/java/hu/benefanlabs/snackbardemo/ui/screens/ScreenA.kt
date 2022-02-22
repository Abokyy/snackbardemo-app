package hu.benefanlabs.snackbardemo.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import hu.benefanlabs.snackbardemo.ui.navigation.NavigationRoutes

@Composable
fun ScreenA(
    showSnackbar: (String, SnackbarDuration) -> Unit,
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(modifier = Modifier.align(Alignment.TopCenter), text = "Current screen: A")
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Button(
                onClick = {
                    showSnackbar("Navigated from A to B", SnackbarDuration.Short)
                    navController.navigate(NavigationRoutes.ScreenB.route)
                }
            ) {
                Text("Navigate to ScreenB")
            }
            Button(
                modifier = Modifier.padding(top = 20.dp),
                onClick = {
                    showSnackbar("Navigated from A to C", SnackbarDuration.Short)
                    navController.navigate(NavigationRoutes.ScreenC.route)
                }
            ) {
                Text("Navigate to ScreenC")
            }
        }
    }
}