package de.timograw.badge35c3.elements

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import de.timograw.badge35c3.constants.Memories
import kotlin.math.roundToInt

class RainbowAnimation constructor(context: Context): AbstractAnimation(context) {

    val paints = listOf(Paint(),Paint(),Paint(),Paint(),Paint(),Paint(),Paint(),Paint())

    var hue = 0

    var currentAlphaChar = 0
    var currentAlpha = 0

    init {
        for (i in 0 .. 7) {
            paints[i].color = Color.HSVToColor(floatArrayOf(((360f / 8f * i) + 360 - hue) % 360, 1f, 1f))
            paints[i].alpha = 0
        }
    }

    override fun draw(canvas: Canvas) {
        for (i in 0 .. 7)
            canvas.drawRect(Memories.characterRects[i], paints[i])
    }

    override fun update() {
        hue += 2

        if (hue > 360) {
            hue %= 360
        }

        for (i in 0 .. 7) {
            var alpha = 0
            when {
                i < currentAlphaChar -> alpha = 255
                i == currentAlphaChar -> alpha = currentAlpha
                i > currentAlpha -> alpha = 0
            }
            paints[i].color = Color.HSVToColor(alpha, floatArrayOf(((360f / 8f * i) + 360 - hue) % 360, 1f, 1f))
        }


        if (!isFinished) {
            currentAlpha += 10

            if (currentAlpha >= 255) {
                currentAlpha = 0
                currentAlphaChar++
            }

            if (currentAlphaChar == 8)
                setFinished()
        }
    }

    override fun reset() {
    }

}