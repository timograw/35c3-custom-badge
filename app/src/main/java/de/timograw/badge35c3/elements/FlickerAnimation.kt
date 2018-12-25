package de.timograw.badge35c3.elements

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import de.timograw.badge35c3.constants.Refreshing

class FlickerAnimation constructor(context: Context): AbstractAnimation(context) {

    val refreshingRect = Rect(0, Refreshing.top, screenWidth, Refreshing.top + Refreshing.height)

    val paint = Paint()

    val switches = listOf(240, 2, 40, 3, 20, 10, 30, 60)

    var currentSwitch = 0

    var currentCount = switches[0]

    init {
        paint.color = Color.BLACK
    }

    override fun draw(canvas: Canvas) {
        canvas.drawRect(refreshingRect, paint)
    }

    override fun update() {
        if (isFinished) return

        currentCount--
        if (currentCount <= 0) {
            if (paint.color == Color.BLACK)
                paint.color = Color.WHITE
            else
                paint.color = Color.BLACK

            currentSwitch++
            if (currentSwitch == switches.count()) {
                currentSwitch = 0
                paint.color = Color.WHITE
                setFinished()
            }
            currentCount = switches[currentSwitch]
        }
    }

    override fun reset() {
        currentSwitch = 0
        currentCount = switches[0]
        resetFinished()
    }

}