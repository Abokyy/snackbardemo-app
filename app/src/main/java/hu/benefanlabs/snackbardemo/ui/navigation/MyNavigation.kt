package hu.benefanlabs.snackbardemo.ui.navigation

import androidx.compose.material.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import hu.benefanlabs.snackbardemo.ui.components.CustomSnackbarType
import hu.benefanlabs.snackbardemo.ui.screens.ScreenA
import hu.benefanlabs.snackbardemo.ui.screens.ScreenB
import hu.benefanlabs.snackbardemo.ui.screens.ScreenC

@Composable
fun MyNavigation(
    navController: NavHostController,
    showSnackbar: (String, SnackbarDuration, CustomSnackbarType) -> Unit
) {
    NavHost(navController = navController, startDestination = NavigationRoutes.ScreenA.route) {

        composable(route = NavigationRoutes.ScreenA.route) {
            ScreenA(showSnackbar = showSnackbar, navController = navController)
        }

        composable(route = NavigationRoutes.ScreenB.route) {
            ScreenB(showSnackbar = showSnackbar, navController = navController)
        }

        composable(route = NavigationRoutes.ScreenC.route) {
            ScreenC()
        }

    }
}