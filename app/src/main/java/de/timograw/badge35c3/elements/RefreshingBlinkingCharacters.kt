package de.timograw.badge35c3.elements

import android.content.Context
import android.graphics.*
import de.timograw.badge35c3.constants.BadgeColors
import de.timograw.badge35c3.constants.Refreshing

class RefreshingBlinkingCharacters constructor(context: Context): AbstractAnimation(context) {

    val paint: Paint = Paint()

    var currentCharacter = 0
    var counter = 0
    val modulo = 5

    init {
        val logoGradient = LinearGradient(0f, 0f, 0f+screenWidth.toFloat(), 0f, intArrayOf(BadgeColors.BRIGHT_FRESH, BadgeColors.BRIGHT_HOPE), floatArrayOf(0f, 1f), Shader.TileMode.MIRROR)
        //paint.color = BadgeColors.BRIGHT_FRESH
        paint.shader = logoGradient
    }

    override fun update() {
        counter += 1
        if (counter == modulo) {
            counter = 0

            currentCharacter = (currentCharacter + 1)

            if (currentCharacter == Refreshing.characterCount) {
                currentCharacter = 0
                setFinished()
            }
        }
    }

    override fun draw(canvas: Canvas) {
        canvas.drawRect(Refreshing.characterRects[currentCharacter], paint)
    }

    override fun reset() {
        currentCharacter = 0
        counter = 0
        resetFinished()
    }

}