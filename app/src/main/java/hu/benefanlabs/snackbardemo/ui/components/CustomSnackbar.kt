package hu.benefanlabs.snackbardemo.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


enum class CustomSnackbarType {
    ERROR, NORMAL
}

@Stable
class CustomSnackbarState(
    val snackbarHostState: SnackbarHostState,
    var currentSnackbarType: CustomSnackbarType = CustomSnackbarType.NORMAL
)

@Composable
fun CustomSnackbar(
    state: CustomSnackbarState
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        SnackbarHost(
            hostState = state.snackbarHostState,
            snackbar = { snackbarData: SnackbarData ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color.Gray,
                    border = BorderStroke(2.dp, Color.Black),
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentSize()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val icon = when (state.currentSnackbarType) {
                            CustomSnackbarType.ERROR -> Icons.Default.Close
                            CustomSnackbarType.NORMAL -> Icons.Default.Notifications
                        }
                        Icon(
                            imageVector = icon,
                            contentDescription = ""
                        )
                        Text(text = snackbarData.message)
                    }
                }
            }
        )
    }
}
