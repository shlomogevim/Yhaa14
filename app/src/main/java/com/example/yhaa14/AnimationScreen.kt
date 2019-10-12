package com.example.yhaa14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_animation_screen.*


class AnimationScreen : AppCompatActivity() {
    companion object {
        const val COUNTER = "counter"
        const val SPEAKER = "speaker"
    }

    private lateinit var orderList: ArrayList<String>
    private lateinit var godList: ArrayList<String>
    private lateinit var manList: ArrayList<String>

    private lateinit var speakList: ArrayList<Speaker>

    private var manMode = true
    private var counterStep = 0
    private var stringStep = ""

    lateinit var animationInAction: AnimationAction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_screen)

        speakList = intent.getSerializableExtra(SPEAKER) as ArrayList<Speaker>
        counterStep = intent.getIntExtra(COUNTER, 0)
        if (counterStep < 0) counterStep = 0

        animationInAction = AnimationAction(this, mainLayout)
        generalOperation()
        goddy.setOnClickListener {
            if (!manMode) {
                generalOperation()
                manMode = true
            } else {
                Toast.makeText(this, "נסה שוב, זה התור של האדם לדבר", Toast.LENGTH_LONG).show()
            }
        }

        man.setOnClickListener {
            //operateMan(manList[round])
            if (manMode) {
                generalOperation()
                manMode = false
            } else {
                Toast.makeText(this, "נסה שוב, זה התור של האין סוף להגיב", Toast.LENGTH_LONG).show()

            }

        }

    }


    private fun generalOperation() {
        counterStep++

        manMode = counterStep % 2 != 0

        updateTitleSituation()

        operatAnimation()

        //     val speaker = speakList[counterStep]
//        if (manMode) {
//            operateMan(speaker)
//        } else {
//            operateGoddy(speaker)
//        }


        manMode = !manMode
    }

    private fun operatAnimation() {

//        counterStep = 13
        var arr1 = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
        if (arr1.contains(counterStep)) {


            val speaker = speakList[counterStep]
            when (counterStep) {
                1 -> animationInAction.manMove20(speaker)
                2, 4, 6, 8 -> animationInAction.godMove11A(speaker)
                3 -> animationInAction.manStatic50(2, speaker)
                5 -> animationInAction.manStatic40(2, speaker)
                7 -> animationInAction.manStatic20(0, speaker)
                9 -> animationInAction.manStatic30(1, speaker)
                10 -> animationInAction.godStatic60(0, speaker)
                11 -> animationInAction.manStatic10(0, speaker)
                12 -> animationInAction.godStatic40(0, speaker)
            }

        }else{
            regularAnimation()
        }
    }

    private fun regularAnimation() {
        val speaker = speakList[counterStep]
        val kind=speaker.whoSpeake
        val st = speaker.taking
        val arr = st.split("\n")
        if (kind=="man"){
            when (arr.size){
                1->animationInAction.manStatic10(0,speaker)
                2->animationInAction.manStatic20(0,speaker)
                3->animationInAction.manStatic30(0,speaker)
                4->animationInAction.manStatic40(0,speaker)
                5->animationInAction.manStatic50(0,speaker)
                6->animationInAction.manStatic60(0,speaker)
            }
        }else{
            when (arr.size){
                1->animationInAction.godStatic10(0,speaker)
                2->animationInAction.godStatic20(0,speaker)
                3->animationInAction.godStatic30(0,speaker)
                4->animationInAction.godStatic40(0,speaker)
                5->animationInAction.godStatic50(0,speaker)
                6->animationInAction.godStatic60(0,speaker)
            }
        }

    }

    private fun operateGoddy(speaker: Speaker) {
        val st = speaker.taking
        val arr = st.split("\n")
        val size = arr.size

        when (size) {
            1 -> animationInAction.godTranslaion11A(speaker)
            2 -> animationInAction.godTranslation20(speaker)
            3 -> animationInAction.godTranslaion30(arr, counterStep)
            4 -> when (counterStep) {
                12 -> animationInAction.godTranslaion40A(speaker)
                else -> animationInAction.godTranslaion40(speaker)


            }
            5 -> animationInAction.godTranslaion50(arr, counterStep)
            6 -> animationInAction.godTranslaion60A(speaker)
        }
    }

    private fun operateMan(speaker: Speaker) {
        val st = speaker.taking
        val arr = st.split("\n")
        val size = arr.size


        when (size) {
            1 -> animationInAction.manTranslation10(speaker)
            2 -> animationInAction.manTranslation20A(speaker)
            3 -> animationInAction.manTranslaion30(speaker)
            4 -> animationInAction.manTranslaion40(speaker)
            5 -> animationInAction.manTranslaion50(arr, counterStep)
        }
    }

    private fun updateTitleSituation() {
        title_situation.text = "madMode=$manMode round=${(counterStep - 1) / 2}"
        counter_situation.text = "counter=$counterStep"
    }
}




