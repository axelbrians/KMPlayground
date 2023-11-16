package components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun interface OnSelectableItemViewClicked {
    operator fun invoke(index: Int)
}

@Composable
fun SelectableItemView(
    index: Int,
    isSelected: Boolean,
    onClick: OnSelectableItemViewClicked,
    modifier: Modifier = Modifier
) {

    val backgroundColor by remember(isSelected) {
        val color = if (isSelected) {
            Color.Cyan
        } else {
            Color.Transparent
        }
        mutableStateOf(color)
    }

    val animatedBackgroundColor = animateColorAsState(backgroundColor)

    Row(
        modifier = modifier
            .clickable { onClick(index) }
            .background(animatedBackgroundColor.value)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.size(32.dp).clip(CircleShape).background(Color.DarkGray))
        Spacer(Modifier.width(16.dp))
        Text(
            text = "Hello my $index world",
            fontWeight = FontWeight(600),
            fontSize = 16.sp
        )
    }
}
