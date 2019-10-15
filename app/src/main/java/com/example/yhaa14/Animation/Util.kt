package com.example.yhaa14.Animation

import android.content.res.Resources
import android.widget.TextView
import com.github.florent37.viewanimator.ViewAnimator

object Util {
    var wi: Float = Resources.getSystem().displayMetrics.widthPixels.toFloat()
    var hi: Float = Resources.getSystem().displayMetrics.heightPixels.toFloat()


    private fun ttMove1(
        textView: TextView,
        x0: Float,
        x1: Float,
        y0: Float,
        y1: Float,
        scale0: Float,
        scale1: Float,
        duration: Long
    ) {
        ViewAnimator
            .animate(textView)
            .translationX(x0, x1)
            .translationY(y0, y1)
            .scale(scale0, scale1)
            .duration(duration)
            .start()
    }

    fun move1(textView1: TextView, textView2: TextView) {
        ttMove1(
            textView1, -wi / 2, 0f, -hi, 0f, 0f, 1f, 2000
        )
        ttMove1(
            textView2, wi / 2, 0f, -hi, 0f, 0f, 1f, 2000
        )
    }

    fun move1g(textView1: TextView, textView2: TextView) {
        ttMove1(
            textView1,
            -wi / 2,
            0f,
            hi,
            0f,
            0f,
            2f,
            2000
        )
        ttMove1(
            textView2,
            wi / 2,
            0f,
            hi,
            0f,
            0f,
            2f,
            2000
        )
    }

    fun move1god(textView1: TextView, textView2: TextView, dur: Long) {
      ttMove1(textView1, wi / 2, 0f, hi, 0f, 0f, 1f, dur)
        ttMove1(textView2, -wi / 2, 0f, hi, 0f, 0f, 1f, dur)
    }

    private fun ttScale(textView: TextView, dur: Long) {
        ViewAnimator.animate(textView).scale(0f, 1f).duration(dur).start()
    }

    fun scale10(textView1: TextView, dur: Long) {
        ttScale(textView1, dur)
    }

    fun scale11(textView1: TextView, dur: Long) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .start()
    }
    fun scale12(textView1: TextView,dur: Long) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView1)
            .swing()
            .start()
    }


    fun scale20(textView1: TextView, textView2: TextView, dur: Long) {
        ttScale(textView1, dur)
        ttScale(textView2, dur)
    }

    fun scale21(textView1: TextView, textView2: TextView, dur: Long) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView2)
            .scale(0f, 1f)
            .duration(dur)
            .start()
    }

    fun scale22(textView1: TextView, textView2: TextView, dur: Long) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView2)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView1)
            .swing()
            .start()
    }

    fun scale30(textView1: TextView, textView2: TextView, textView3: TextView, dur: Long) {
        ttScale(textView1, dur)
        ttScale(textView2, dur)
        ttScale(textView3, dur)
    }

    fun scale31(textView1: TextView, textView2: TextView, textView3: TextView, dur: Long) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView2)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView3)
            .scale(0f, 1f)
            .duration(dur)
            .start()
    }

    fun scale32(textView1: TextView, textView2: TextView, textView3: TextView, dur: Long) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView2)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView3)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView1)
            .swing()
            .start()
    }
    fun scale33(
        textView1: TextView, textView2: TextView, textView3: TextView,dur: Long
    ) {
        rotateAndMove(1, textView1, dur)
        rotateAndMove(2, textView2, dur)
        rotateAndMove(3, textView3, dur)
    }

    fun scale40(
        textView1: TextView, textView2: TextView, textView3: TextView,
        textView4: TextView, dur: Long
    ) {
        ttScale(textView1, dur)
        ttScale(textView2, dur)
        ttScale(textView3, dur)
        ttScale(textView4, dur)
    }

    fun scale41(
        textView1: TextView, textView2: TextView, textView3: TextView,
        textView4: TextView, dur: Long
    ) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView2)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView3)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView4)
            .scale(0f, 1f)
            .duration(dur)
            .start()
    }

    fun scale42(
        textView1: TextView,
        textView2: TextView,
        textView3: TextView,
        textView4: TextView,
        dur: Long
    ) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView2)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView3)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView4)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView1)
            .swing()
            .start()
    }

    fun scale13(
        textView1: TextView,dur: Long
    ) {
        rotateAndMove(1, textView1, dur)
    }
    fun scale23(textView1: TextView, textView2: TextView,dur: Long
    ) {
        rotateAndMove(1, textView1, dur)
        rotateAndMove(2, textView2, dur)
    }

    fun scale43(
        textView1: TextView, textView2: TextView, textView3: TextView, textView4: TextView,
        dur: Long
    ) {
        rotateAndMove(1, textView1, dur)
        rotateAndMove(2, textView2, dur)
        rotateAndMove(3, textView3, dur)
        rotateAndMove(4, textView4, dur)
    }

    fun scale50(
        textView1: TextView,
        textView2: TextView,
        textView3: TextView,
        textView4: TextView,
        textView5: TextView,
        dur: Long
    ) {
        ttScale(textView1, dur)
        ttScale(textView2, dur)
        ttScale(textView3, dur)
        ttScale(textView4, dur)
        ttScale(textView5, dur)
    }

    fun scale51(
        textView1: TextView,
        textView2: TextView,
        textView3: TextView,
        textView4: TextView,
        textView5: TextView,
        dur: Long
    ) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView2)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView3)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView4)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView5)
            .scale(0f, 1f)
            .duration(dur)
            .start()
    }

    fun scale52(
        textView1: TextView,
        textView2: TextView,
        textView3: TextView,
        textView4: TextView,
        textView5: TextView,
        dur: Long
    ) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView2)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView3)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView4)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView5)
            .scale(0f, 1f)
            .onStop {
                ViewAnimator
                    .animate(textView5)
                    .scale(1f, 0f, 1f)
                    .repeatCount(1)
                    .duration(1000)
                    .start()
            }
            .duration(dur)
            .start()
    }

    fun scale53(
        textView1: TextView, textView2: TextView, textView3: TextView, textView4: TextView,
        textView5: TextView, dur: Long
    ) {

        rotateAndMove(1, textView1, dur)
        rotateAndMove(2, textView2, dur)
        rotateAndMove(3, textView3, dur)
        rotateAndMove(4, textView4, dur)
        rotateAndMove(5, textView5, dur)
    }

    fun scale60(
        textView1: TextView,
        textView2: TextView,
        textView3: TextView,
        textView4: TextView,
        textView5: TextView,
        textView6: TextView,
        dur: Long
    ) {
        ttScale(textView1, dur)
        ttScale(textView2, dur)
        ttScale(textView3, dur)
        ttScale(textView4, dur)
        ttScale(textView5, dur)
        ttScale(textView6, dur)
    }

    fun scale61(
        textView1: TextView,
        textView2: TextView,
        textView3: TextView,
        textView4: TextView,
        textView5: TextView,
        textView6: TextView,
        dur: Long
    ) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView2)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView3)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView4)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView5)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView6)
            .scale(0f, 1f)
            .duration(dur)
            .start()
    }

    fun scale62(
        textView1: TextView, textView2: TextView, textView3: TextView, textView4: TextView,
        textView5: TextView, textView6: TextView, dur: Long
    ) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView2)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView3)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView4)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView5)
            .scale(0f, 1f)
            .thenAnimate(textView6)
            .scale(0f, 1f)
            .onStop {
                ViewAnimator
                    .animate(textView6)
                    .scale(1f, 0f, 1f)
                    .repeatCount(1)
                    .duration(1000)
                    .start()
            }
            .duration(dur)
            .start()
    }

    fun scale63(
        textView1: TextView, textView2: TextView, textView3: TextView, textView4: TextView,
        textView5: TextView, textView6: TextView, dur: Long
    ) {

        rotateAndMove(1, textView1, dur)
        rotateAndMove(2, textView2, dur)
        rotateAndMove(3, textView3, dur)
        rotateAndMove(4, textView4, dur)
        rotateAndMove(5, textView5, dur)
        rotateAndMove(6, textView6, dur)
    }

    fun rotateAndMove(ind: Int, textView: TextView, dur: Long) {
        var x0 = 0f
        var y0 = 0f
        var rotate = 360f
        when (ind) {
            1 -> {
                x0 = -wi / 2
                y0 = -hi
                rotate = 720f * 2
            }
            2 -> {
                x0 = wi / 2
                y0 = -hi
                rotate = -720f * 2
            }
            3 -> {
                x0 = -wi / 2
                y0 = 0f
                rotate = 360f
            }
            4 -> {
                x0 = wi / 2
                y0 = 0f
                rotate = -360f
            }
            5 -> {
                x0 = -wi / 2
                y0 = hi
                rotate = 720f * 2
            }
            6 -> {
                x0 = wi / 2
                y0 = hi
                rotate = -720f * 2
            }
        }
        ViewAnimator
            .animate(textView)
            .scale(0f, 1f)
            .translationX(x0, 0f)
            .translationY(y0, 0f)
            .rotation(rotate)
            .duration(dur)
            .start()


    }

}
