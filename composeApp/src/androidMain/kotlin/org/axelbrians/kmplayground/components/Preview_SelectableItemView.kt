package org.axelbrians.kmplayground.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import components.SelectableItemView

@Preview
@Composable
private fun Preview_SelectableItemView() {
    SelectableItemView(
        index = 0,
        isSelected = true,
        onClick = { _ -> }
    )
}