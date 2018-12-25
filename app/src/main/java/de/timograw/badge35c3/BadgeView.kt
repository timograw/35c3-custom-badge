package de.timograw.badge35c3

import android.content.Context
import android.graphics.*
import android.view.View
import de.timograw.badge35c3.elements.*
import kotlin.math.roundToLong


/**
 * TODO: document your custom view class.
 */
class BadgeView : View {

    private var xMin = 0          // This view's bounds
    private var xMax: Int = 0
    private var yMin = 0
    private var yMax: Int = 0
    private val ballRadius = 80f // Ball's radius
    private var ballX = ballRadius + 20  // Ball's center (x,y)
    private var ballY = ballRadius + 40
    private var ballSpeedX = 5f  // Ball's speed (x,y)
    private var ballSpeedY = 3f
    private var ballBounds: RectF? = null      // Needed for Canvas.drawOval


    val paint: Paint = Paint()           // The paint (e.g. style, color) used for drawing


    var gradX = 0f

    var screenWidth: Int = 0
    var screenHeight: Int = 0

    var elements: MutableList<AbstractAnimation> = mutableListOf()

    val fps = 60f

    constructor(context: Context) : super(context) {
        //ballBounds = RectF()
        //paint = Paint()

        this.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN or SYSTEM_UI_FLAG_HIDE_NAVIGATION or SYSTEM_UI_FLAG_IMMERSIVE

        val metrics = context.resources.displayMetrics
        screenWidth = metrics.widthPixels
        screenHeight = metrics.heightPixels

        val flickerAnimation = FlickerAnimation(context)
        val rainbowAnimation = RainbowAnimation(context)
        val logoGradientAnimation = LogoGradientAnimation(context)

        elements.add(
            AnimationSequence(context,
                flickerAnimation,
                ConcurrentAnimation(context,
                    rainbowAnimation,
                    flickerAnimation),
                ConcurrentAnimation(context,
                    logoGradientAnimation,
                    flickerAnimation,
                    rainbowAnimation))
            )

    }

    var previousTime = System.currentTimeMillis()

    // Called back to draw the view. Also called by invalidate().
    override fun onDraw(canvas: Canvas) {
        // Draw the ball
        //ballBounds?.set(ballX - ballRadius, ballY - ballRadius, ballX + ballRadius, ballY + ballRadius)
        //paint.setColor(Color.BRIGHT_HOPE)
        //canvas.drawOval(ballBounds, paint)


        elements.forEach { it.draw(canvas) }

        elements.forEach { it.update() }

        // Update the left of the ball, including collision detection and reaction.
        //update()

        // Delay
        try {
            val currentTimeMillis = System.currentTimeMillis()
            val elapsedTimeMs = currentTimeMillis - previousTime
            val sleepTimeMs = (1000f / fps - elapsedTimeMs).roundToLong()
            if (sleepTimeMs > 0)
                Thread.sleep(sleepTimeMs)
        } catch (e: InterruptedException) {
        }

        invalidate()  // Force a re-draw
        previousTime = System.currentTimeMillis()
    }


    // Called back when the view is first created or its size changes.
    public override fun onSizeChanged(w: Int, h: Int, oldW: Int, oldH: Int) {
        // Set the movement bounds for the ball
        xMax = w - 1
        yMax = h - 1
    }

}
