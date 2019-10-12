package com.example.yhaa14

import android.content.res.Resources
import android.widget.TextView
import com.github.florent37.viewanimator.ViewAnimator

object Util {
    private var wi: Float = Resources.getSystem().displayMetrics.widthPixels.toFloat()
    private var hi: Float = Resources.getSystem().displayMetrics.heightPixels.toFloat()
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
        ttMove1(textView1, -wi / 2, 0f, -hi, 0f, 0f, 1f, 2000)
        ttMove1(textView2, wi / 2, 0f, -hi, 0f, 0f, 1f, 2000)
    }

    fun move1g(textView1: TextView, textView2: TextView) {
        ttMove1(textView1, -wi / 2, 0f, hi, 0f, 0f, 2f, 2000)
        ttMove1(textView2, wi / 2, 0f, hi, 0f, 0f, 2f, 2000)
    }

    private fun ttScale(textView: TextView, dur: Long) {
        ViewAnimator.animate(textView).scale(0f, 1f).duration(dur).start()
    }
    fun scale10(
        textView1: TextView,
        dur: Long
    ) {
        ttScale(textView1, dur)
    }


    fun scale11(
        textView1: TextView,
        dur: Long
    ) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .swing()
            .start()
    }
    fun scale20(
        textView1: TextView,
        textView2: TextView,
        dur: Long
    ) {
        ttScale(textView1, dur)
        ttScale(textView2, dur)
    }

    fun scale21(
        textView1: TextView,
        textView2: TextView,
        dur: Long
    ) {
        ViewAnimator
            .animate(textView1)
            .scale(0f, 1f)
            .duration(dur)
            .thenAnimate(textView2)
            .scale(0f, 1f)
            .duration(dur)
            .start()
    }
    fun scale22(
        textView1: TextView,
        textView2: TextView,
        dur: Long
    ) {
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
    fun scale30(
        textView1: TextView,
        textView2: TextView,
        textView3: TextView,
        dur: Long
    ) {
        ttScale(textView1, dur)
        ttScale(textView2, dur)
        ttScale(textView3, dur)
    }

    fun scale31(
        textView1: TextView,
        textView2: TextView,
        textView3: TextView,
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
            .start()
    }
    fun scale32(
        textView1: TextView,
        textView2: TextView,
        textView3: TextView,
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
            .thenAnimate(textView1)
            .swing()
            .start()
    }

    fun scale40(
        textView1: TextView,
        textView2: TextView,
        textView3: TextView,
        textView4: TextView,
        dur: Long
    ) {
        ttScale(textView1, dur)
        ttScale(textView2, dur)
        ttScale(textView3, dur)
        ttScale(textView4, dur)
    }

    fun scale41(
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

}