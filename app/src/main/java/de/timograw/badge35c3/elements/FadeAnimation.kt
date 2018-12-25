package de.timograw.badge35c3.elements

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

enum class FadeType {
    FadeIn,
    FadeOut
}

class FadeAnimation constructor(context: Context, fadeType: FadeType, paint: Paint = Paint()): AbstractAnimation(context) {

    override fun draw(canvas: Canvas) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reset() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}