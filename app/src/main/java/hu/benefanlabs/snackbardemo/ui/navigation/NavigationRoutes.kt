package hu.benefanlabs.snackbardemo.ui.navigation

sealed class NavigationRoutes(
    val route: String
) {
    object ScreenA: NavigationRoutes(route = "A")
    object ScreenB: NavigationRoutes(route = "B")
    object ScreenC: NavigationRoutes(route = "C")
}