package de.timograw.badge35c3.elements

import android.content.Context
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import de.timograw.badge35c3.constants.BadgeColors
import de.timograw.badge35c3.constants.Memories
import de.timograw.badge35c3.constants.Refreshing

class FillingTextAnimation constructor(context: Context): AbstractAnimation(context) {

    val charactersRects = Refreshing.characterRects.union(Memories.characterRects).toList()

    val characterCount = charactersRects.count()

    var currentCharacter = 0
    var revealedCharactesCount = 0

    val modulo = 2

    var counter = 0

    val paint: Paint = Paint()

    init {
        val logoGradient = LinearGradient(0f, 0f, 0f+screenWidth.toFloat(), 0f, intArrayOf(BadgeColors.BRIGHT_FRESH_INVERTED, BadgeColors.BRIGHT_HOPE_INVERTED), floatArrayOf(0f, 1f), Shader.TileMode.MIRROR)
        //paint.color = BadgeColors.BRIGHT_FRESH
        paint.shader = logoGradient
    }

    override fun draw(canvas: Canvas) {
        canvas.drawRect(charactersRects[currentCharacter], paint)

        for(i in characterCount - revealedCharactesCount .. characterCount-1)
            canvas.drawRect(charactersRects[i], paint)
    }

    override fun update() {
        counter += 1
        if (counter == modulo) {
            counter = 0

            currentCharacter = (currentCharacter + 1)

            if (currentCharacter == characterCount - revealedCharactesCount) {
                currentCharacter = 0
                revealedCharactesCount++
                if (revealedCharactesCount == characterCount) {
                    setFinished()
                    currentCharacter = 0
                    revealedCharactesCount = 0
                }
            }
        }
    }

    override fun reset() {
        counter = 0
        currentCharacter = 0
        revealedCharactesCount = 0
        resetFinished()
    }


}