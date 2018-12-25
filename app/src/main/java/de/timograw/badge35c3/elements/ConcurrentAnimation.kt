package de.timograw.badge35c3.elements

import android.content.Context
import android.graphics.Canvas

class ConcurrentAnimation(
    context: Context,
    val leadingAnimation: AbstractAnimation,
    vararg val secondaryAnimations: AbstractAnimation
): AbstractAnimation(context) {

    override fun draw(canvas: Canvas) {
        leadingAnimation.draw(canvas)
        secondaryAnimations.forEach { it.draw(canvas) }
    }

    override fun update() {
        leadingAnimation.update()
        secondaryAnimations.forEach { it.update() }
        if (leadingAnimation.isFinished)
            setFinished()
    }

    override fun reset() {
        leadingAnimation.reset()
        secondaryAnimations.forEach { it.reset() }
    }


}