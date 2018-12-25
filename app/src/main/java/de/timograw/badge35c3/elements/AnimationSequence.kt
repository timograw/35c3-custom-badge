package de.timograw.badge35c3.elements

import android.content.Context
import android.graphics.Canvas

class AnimationSequence (context: Context, vararg val animations: AbstractAnimation): AbstractAnimation(context) {

    var activeAnimationIndex = 0

    val activeAnimation
        get() = animations[activeAnimationIndex]


    override fun draw(canvas: Canvas) {
        activeAnimation.draw(canvas)
    }

    override fun update() {
        activeAnimation.update()

        if (activeAnimation.isFinished) {
            activeAnimationIndex++
            if (activeAnimationIndex == animations.count()) {
                activeAnimationIndex = 0
                setFinished()
            }
        }
    }

    override fun reset() {
        activeAnimation.reset()
        activeAnimationIndex = 0
    }

}