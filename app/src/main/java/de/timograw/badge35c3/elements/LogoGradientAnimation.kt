package de.timograw.badge35c3.elements

import android.content.Context
import android.graphics.*
import de.timograw.badge35c3.constants.BadgeColors


class LogoGradientAnimation constructor(context: Context): AbstractAnimation(context) {

    companion object {
        const val logoTop = 720
        const val logoHeight = 400
    }

    private val logoRect = Rect(0, logoTop, screenWidth, logoTop + logoHeight)
    var gradX = 0f

    val paint: Paint = Paint()

    var alpha = 0

    init {
        paint.alpha = 0
    }


    override fun draw(canvas: Canvas) {
        canvas.drawRect(logoRect, paint)
    }

    override fun update() {
        gradX += 15
        if (gradX > screenWidth*2) {
            gradX = 0f
            //setFinished()
        }

        val logoGradient = LinearGradient(gradX, 0f, gradX+screenWidth.toFloat(), 0f, intArrayOf(BadgeColors.BRIGHT_FRESH, BadgeColors.BRIGHT_HOPE), floatArrayOf(0f, 1f), Shader.TileMode.MIRROR)
        paint.shader = logoGradient
        if (alpha < 255)
            alpha += 2

        if (alpha > 255)
            alpha = 255

        paint.alpha = alpha
    }

    override fun reset() {
        gradX = 0f
        resetFinished()
    }

}