import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.SelectableItemView
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(text: String = "Click me!") {
    MaterialTheme {
        var greetingText by remember { mutableStateOf(text) }
        var showImage by remember { mutableStateOf(false) }

        var itemDataSet by remember {
            mutableStateOf(List(100) { false })
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    greetingText = "Compose: ${Greeting().greet()}"
                    showImage = !showImage
                }
            ) {
                Text(greetingText)
            }
            AnimatedVisibility(
                visible = showImage,
                modifier = Modifier.heightIn(max = 120.dp)
            ) {
                Image(
                    painter = painterResource("compose-multiplatform.xml"),
                    contentDescription = "Compose Multiplatform Logo"
                )
            }
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                itemsIndexed(itemDataSet) { index, isSelected ->
                    SelectableItemView(
                        index = index,
                        isSelected = isSelected,
                        onClick = { pos ->
                            val temp = itemDataSet.toMutableList()
                            val prevValue = temp[pos]
                            temp[pos] = !prevValue
                            itemDataSet = temp
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}