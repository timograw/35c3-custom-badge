package de.timograw.badge35c3.elements

import android.content.Context
import android.graphics.Canvas

abstract class AbstractAnimation(val context: Context) {

    var screenWidth = context.resources.displayMetrics.widthPixels
    var screenHeight = context.resources.displayMetrics.heightPixels

    abstract fun draw(canvas: Canvas)

    abstract fun update()

    abstract fun reset()

    protected fun setFinished() {
        finishCount++
        isFinished = true
    }

    protected fun resetFinished() {
        finishCount = 0
        isFinished = false
    }

    var finishCount = 0
    var isFinished = false
}