package site.jcfp.solitaire.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import site.jcfp.solitaire.R

class Card(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint().apply {
        color = Color.RED
        textSize = 20f
    }

    private val outlinePaint = Paint().apply {
        style = Paint.Style.STROKE
        color = Color.RED
        strokeWidth = 2f
    }

    private val icon = context.resources.getDrawable(R.drawable.ic_diamonds, null).apply {
        setBounds(20, 40, 84, 133)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(100, 160)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(Rect(0, 0, 100, 160), outlinePaint)
        canvas.drawText("10", 0f, 20f, paint)
        icon.draw(canvas)
    }
}