package com.example.yhaa14.step_3

import android.content.Context
import android.view.View
import android.widget.TextView
import com.example.yhaa14.utils.*
import com.github.florent37.viewanimator.ViewAnimator
import kotlinx.android.synthetic.main.god_layout.view.*
import kotlinx.android.synthetic.main.man_layout.view.*

class AnimationAction1(context: Context, val view: View) {

    val helper = Helper(context)
    var tv0: TextView? = null
    var tv0A: TextView? = null
    var tv1: TextView? = null
    var tv2: TextView? = null
    var tv3: TextView? = null
    var tv4: TextView? = null
    var tv5: TextView? = null

    //val arrTextView = arrayOf(tv0, tv1, tv2, tv3, tv4, tv5)

    var man0: TextView = view.manSpeaking0
    var man1: TextView = view.manSpeaking1
    var man2: TextView = view.manSpeaking2
    var man3: TextView = view.manSpeaking3
    var man4: TextView = view.manSpeaking4
    var man5: TextView = view.manSpeaking5
    var god0: TextView = view.godSpeaking0
    var god0A: TextView = view.godSpeaking0A
    var god1: TextView = view.godSpeaking1
    var god2: TextView = view.godSpeaking2
    var god3: TextView = view.godSpeaking3
    var god4: TextView = view.godSpeaking4
    var god5: TextView = view.godSpeaking5


    fun manTalk(talker: Talker) {
        initAllManTextview()
        configManTextView1(talker)
        val listOfTextview = arrayListOf(tv0, tv1, tv2, tv3, tv4, tv5)
        val dur = talker.dur
        when (talker.animNum) {
            10 -> Utile1.scale_swing(0,talker,listOfTextview, dur)
            11 -> Utile1.scale_swing(1,talker,listOfTextview, dur)
            12 -> Utile1.scale_swing(2,talker,listOfTextview, dur)
            13 -> Utile1.scale_swing(3,talker,listOfTextview, dur)
            20->Utile1.move_scale(0,listOfTextview,dur)
            21->Utile1.move_scale(1,listOfTextview,dur)
            22->Utile1.move_scale(2,listOfTextview,dur)
            23->Utile1.move_scale(3,listOfTextview,dur)
            24->Utile1.move_scale(4,listOfTextview,dur)
            25->Utile1.move_scale(5,listOfTextview,dur)
            30->Utile1.move_scale_rotate(0,talker,listOfTextview,dur)
            31->Utile1.move_scale_rotate(1,talker,listOfTextview,dur)
            32->Utile1.move_scale_rotate(2,talker,listOfTextview,dur)
            33->Utile1.move_scale_rotate(3,talker,listOfTextview,dur)
            34->Utile1.move_scale_rotate(4,talker,listOfTextview,dur)
            35->Utile1.move_scale_rotate(5,talker,listOfTextview,dur)
            36->Utile1.move_scale_rotate(6,talker,listOfTextview,dur)
            40 -> Utile1.scale11(listOfTextview, dur)
            41 -> Utile1.scale12(listOfTextview, dur)
            42 -> Utile1.scale13(listOfTextview, dur)
        }
        fadeDownAllGod(dur)
    }


    fun godTalk(talker: Talker) {
        initAllGodTextview()
        // val animKind = talker.styleNum
        val st = talker.taking
        val arr = st.split("\n")
        val size = arr.size

        tv0 = styleTextViewTalk1(god0, arr[0], talker)
        tv0A = styleTextViewTalk1(god0A, arr[0], talker)
        if (size > 1) tv1 = styleTextViewTalk1(god1, arr[1], talker)
        if (size > 2) tv2 = styleTextViewTalk1(god2, arr[2], talker)
        if (size > 3) tv3 = styleTextViewTalk1(god3, arr[3], talker)
        if (size > 4) tv4 = styleTextViewTalk1(god4, arr[4], talker)
        if (size > 5) tv5 = styleTextViewTalk1(god5, arr[5], talker)

        val listOfTextview =
            arrayListOf(tv0, tv1, tv2, tv3, tv4, tv5, tv0A)
        val dur = talker.dur
        when (talker.animNum) {
           /* 0 -> Utile1.scale10(listOfTextview, dur)
            //10 -> Utile1.scale11(listOfTextview, dur)
            10 -> Utile1.scale_swing(0,talker,listOfTextview, dur)

            20 -> Utile1.scale12(listOfTextview, dur)
            3 -> Utile1.scale13(listOfTextview, dur)*/

            4 -> Utile1.god10A(listOfTextview, dur)
            10 -> Utile1.scale_swing(0,talker,listOfTextview, dur)
            11 -> Utile1.scale_swing(1,talker,listOfTextview, dur)
            12 -> Utile1.scale_swing(2,talker,listOfTextview, dur)
            13 -> Utile1.scale_swing(3,talker,listOfTextview, dur)
            20->Utile1.move_scale(0,listOfTextview,dur)
            21->Utile1.move_scale(1,listOfTextview,dur)
            22->Utile1.move_scale(2,listOfTextview,dur)
            23->Utile1.move_scale(3,listOfTextview,dur)
            24->Utile1.move_scale(4,listOfTextview,dur)
            25->Utile1.move_scale(5,listOfTextview,dur)
            30->Utile1.move_scale_rotate(0,talker,listOfTextview,dur)
            31->Utile1.move_scale_rotate(1,talker,listOfTextview,dur)
            32->Utile1.move_scale_rotate(2,talker,listOfTextview,dur)
            33->Utile1.move_scale_rotate(3,talker,listOfTextview,dur)
            34->Utile1.move_scale_rotate(4,talker,listOfTextview,dur)
            35->Utile1.move_scale_rotate(5,talker,listOfTextview,dur)
            36->Utile1.move_scale_rotate(6,talker,listOfTextview,dur)
            40 -> Utile1.scale11(listOfTextview, dur)
            41 -> Utile1.scale12(listOfTextview, dur)
            42 -> Utile1.scale13(listOfTextview, dur)

        }
        fadeDownAllMan(dur)
    }

    private fun findStyleObject(index: Int): StyleObject {
        var style1 = StyleObject()
        var bo = true
        var i = 0
        while (bo && i < Page.styleArray.size) {

            if (Page.styleArray[i].num == index) {
                style1 = Page.styleArray[i]
                bo = false
            }
            i++
        }
        return style1
    }

    private fun styleTextViewTalk1(tv: TextView, st: String, talker: Talker): TextView {
        val num = talker.styleNum
        val textSize = talker.textSize
        var textView = tv
        val style = findStyleObject(num)


        with(style) {
            if (colorBack == "none") {
                textView.setBackgroundResource(android.R.color.transparent)
            } else {
                textView.setBackgroundColor(android.graphics.Color.parseColor(colorBack))
            }
            textView.setTextColor(android.graphics.Color.parseColor(colorText))
            textView.setTextSize(android.util.TypedValue.COMPLEX_UNIT_SP, textSize)
            textView.typeface = helper.getTypeFace(1)


            var stam = textView.typeface
            textView.setPadding(paddingLeft, paddingTop, paddingRight, paddingButton)
            textView.text = st
        }
        return textView
    }


    private fun configManTextView1(talker: Talker) {
        val st = talker.taking
        val arr = st.split("\n")
        val size = arr.size
        if (size == 6) {
            tv0 = styleTextViewTalk1(man0, arr[0], talker)
            if (size > 1) tv1 = styleTextViewTalk1(man1, arr[1], talker)
            if (size > 2) tv2 = styleTextViewTalk1(man2, arr[2], talker)
            if (size > 3) tv3 = styleTextViewTalk1(man3, arr[3], talker)
            if (size > 4) tv4 = styleTextViewTalk1(man4, arr[4], talker)
            if (size > 5) tv5 = styleTextViewTalk1(man5, arr[5], talker)
        }
        if (size == 5) {
            tv0 = styleTextViewTalk1(man1, arr[0], talker)
            if (size > 1) tv1 = styleTextViewTalk1(man2, arr[1], talker)
            if (size > 2) tv2 = styleTextViewTalk1(man3, arr[2], talker)
            if (size > 3) tv3 = styleTextViewTalk1(man4, arr[3], talker)
            if (size > 4) tv4 = styleTextViewTalk1(man5, arr[4], talker)
        }
        if (size == 4) {
            tv0 = styleTextViewTalk1(man2, arr[0], talker)
            if (size > 1) tv1 = styleTextViewTalk1(man3, arr[1], talker)
            if (size > 2) tv2 = styleTextViewTalk1(man4, arr[2], talker)
            if (size > 3) tv3 = styleTextViewTalk1(man5, arr[3], talker)
        }
        if (size == 3) {
            tv0 = styleTextViewTalk1(man3, arr[0], talker)
            if (size > 1) tv1 = styleTextViewTalk1(man4, arr[1], talker)
            if (size > 2) tv2 = styleTextViewTalk1(man5, arr[2], talker)
        }
        if (size == 2) {
            tv0 = styleTextViewTalk1(man4, arr[0], talker)
            if (size > 1) tv1 = styleTextViewTalk1(man5, arr[1], talker)
        }
        if (size == 1) {
            tv0 = styleTextViewTalk1(man5, arr[0], talker)
        }
    }





    fun initAllManTextview() {
        man0.text = ""
        man1.text = ""
        man2.text = ""
        man3.text = ""
        man4.text = ""
        man5.text = ""
        ViewAnimator
            .animate(man1, man2, man3, man4, man5, man0)
            .scale(0f)
            .alpha(1f)
            .duration(1)
            .start()
    }

    fun initAllGodTextview() {
        god0.text = ""
        god1.text = ""
        god0A.text = ""
        god2.text = ""
        god3.text = ""
        god4.text = ""
        god5.text = ""
        ViewAnimator
            .animate(god0, god0A, god1, god2, god3, god4, god5)
            .scale(0f)
            .alpha(1f)
            .duration(1)
            .start()
    }

    fun fadeDownAllMan(dur: Long) {

        ViewAnimator
            .animate(man1, man2, man3, man4, man5, man0)
            .alpha(0f)
            .duration(dur)
            .start()
    }


    fun fadeDownAllGod(dur: Long) {
        ViewAnimator
            .animate(god0, god1, god0A, god2, god3, god4, god5)
            .alpha(0f)
            .duration(dur)
            .start()
    }


    /* fun manTalk(talker: Talker) {
       initAllManTextview()
       configManTextView1(talker)

       val listOfTextview =
           arrayListOf(tv0, tv1, tv2, tv3, tv4, tv5)
       val dur = talker.dur
       when (talker.animNum) {
           0 -> Utile1.scale60A(listOfTextview, dur)
           1 -> Utile1.scale61A(listOfTextview, dur)
           2 -> Utile1.scale62A(listOfTextview, dur)
           3 -> Utile1.scale63A(listOfTextview, dur)

       }
       fadeDownAllGod(dur)
   }
*/
}