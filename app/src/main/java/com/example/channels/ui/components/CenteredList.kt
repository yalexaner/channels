package com.example.channels.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import kotlin.math.ceil
import kotlin.math.max

@Composable
fun CenteredList(
    modifier: Modifier = Modifier,
    centeredElementId: Int,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints = constraints)
        }

        val elementWidth = placeables[0].width
        val sideElementsOnScreen = calculateOnScreenElements(constraints.maxWidth, elementWidth) / 2

        val elementsToPlace = run {
            val elementsToLeft = placeables.takeBefore(centeredElementId, sideElementsOnScreen)
            val elementsToRight = placeables.takeAfter(centeredElementId, sideElementsOnScreen)

            elementsToLeft + placeables[centeredElementId] + elementsToRight
        }

        var xPosition =
            (constraints.maxWidth - elementWidth) / 2 - (elementWidth * sideElementsOnScreen)

        layout(constraints.maxWidth, placeables.maxOf { it.height }) {

            elementsToPlace.forEach { placeable ->
                placeable.place(x = xPosition, y = 0)
                xPosition += elementWidth
            }
        }
    }
}

/**
 * Calculates amount of elements which would fit on the screen.
 * The amount should be odd, so it rounds it to the next odd number.
 */
private fun calculateOnScreenElements(screenWidth: Int, elementWidth: Int): Int {
    val onScreenElements = ceil(screenWidth.toDouble() / elementWidth).toInt()
    return onScreenElements + if (onScreenElements % 2 == 0) 1 else 0
}

private fun List<Placeable>.takeBefore(index: Int, count: Int): List<Placeable> {
    return takeLast(max(count - index, 0)) + subList(max(index - count, 0), index)
}

private fun List<Placeable>.takeAfter(index: Int, count: Int): List<Placeable> {
    return subList(index + 1, size) + take(max(count - (size - 1 - index), 0))
}