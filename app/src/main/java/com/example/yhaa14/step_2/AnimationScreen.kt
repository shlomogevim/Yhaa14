package com.example.yhaa14.step_2

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yhaa14.Animation.StyleAnim
import com.example.yhaa14.R
import com.example.yhaa14.step_3.AnimationAction
import com.example.yhaa14.utils.Speaker
import com.example.yhaa14.utils.Talker
import kotlinx.android.synthetic.main.activity_animation_screen.*
import kotlinx.android.synthetic.main.current_position_layout.*
import kotlinx.android.synthetic.main.god_layout.*
import kotlinx.android.synthetic.main.man_layout.*


class AnimationScreen : AppCompatActivity() {
    companion object {
        const val COUNTER = "counter"
        const val SPEAKER = "speaker"
        const val TALKER = "talker"
    }

    private lateinit var speakList: ArrayList<Speaker>
    private lateinit var talkList: ArrayList<Talker>

    private var manMode = true
    private var counterStep = 1

    lateinit var animationInAction: AnimationAction

    val PREFS_NAME = "myPrefs"
    val CURRENT_SPEAKER = "currentSpeaker"
    lateinit var myPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_screen)

        myPref = getSharedPreferences(PREFS_NAME, 0)
        editor = myPref.edit()


//        editor.putInt(CURRENT_SPEAKER,0)
//        editor.commit()

        speakList = intent.getSerializableExtra(SPEAKER) as ArrayList<Speaker>
        talkList = intent.getSerializableExtra(TALKER) as ArrayList<Talker>


       // counterStep = intent.getIntExtra(COUNTER, 0)
        updateListSpeakerStyle()



        animationInAction = AnimationAction(this, mainLayout)



        generalOperation()

        goddy.setOnClickListener {
            if (!manMode) {
                addToCounter()
            } else {
                Toast.makeText(this, "נסה שוב, זה התור של האדם לדבר", Toast.LENGTH_LONG).show()
            }
        }

        man.setOnClickListener {
            if (manMode) {
                addToCounter()
            } else {
                Toast.makeText(this, "נסה שוב, זה התור של האין סוף להגיב", Toast.LENGTH_LONG).show()
            }
        }
        nextButton.setOnClickListener {
            addToCounter()
        }
        previousButton.setOnClickListener {
            counterStep--
            if (counterStep < 1) counterStep = 1

            editor.putInt(CURRENT_SPEAKER, counterStep)
            editor.commit()

            generalOperation()
        }
    }

    private fun addToCounter() {
        counterStep++
        editor.putInt(CURRENT_SPEAKER, counterStep)
        editor.commit()
        generalOperation()
    }


    private fun updateListSpeakerStyle() {

        for (ind in 0 until speakList.size) {
            speakList[ind] = StyleAnim.updateNewStyle(ind, speakList[ind])
        }

        for (ind in 0 until talkList.size) {
            talkList[ind] = StyleAnim.updateNewTalkerStyle(talkList[ind])
        }
    }


    private fun generalOperation() {

        counterStep = myPref.getInt(CURRENT_SPEAKER, 1)
        if (counterStep < 1) counterStep = 1

        manMode = counterStep % 2 == 0

        val speaker = speakList[counterStep]
        var st = speaker.taking
        val arr = st.split("\n")

        val talker=talkList[counterStep]
        updateTitleTalkerSituation(talker)


        if (speaker.whoSpeake == "man") {
            manAnimations(speaker, arr)
        } else {
            godAnimations(speaker, arr)
        }
    }

    private fun updateTitleTalkerSituation(talker: Talker) {

        var st = talker.taking
        val arr = st.split("\n")
        val lines=arr.size
        title_situation.text = "LinesNum->$lines"
        counter_situation.text = counterStep.toString()
    }

    private fun godAnimations(speaker: Speaker, arr: List<String>) {
        when (arr.size) {
            1 -> when (counterStep) {
                2 -> animationInAction.godSay10(0, speaker, 4000)
                4 -> animationInAction.godSay10(0, speaker, 3000)
                6 -> animationInAction.godSay10(1, speaker, 4000)
                8 -> animationInAction.godSay10(4, speaker, 4000)
                18 -> animationInAction.godSay10(4, speaker, 4000)
                28, 38, 44, 52, 56, 60 -> animationInAction.godSay10(4, speaker, 4000)
                else -> animationInAction.godSay10(0, speaker, 2000)
            }
            2 -> when (counterStep) {
                12 -> animationInAction.godSay20(1, speaker, 4000)
                32 -> animationInAction.godSay20(1, speaker, 2000)

                else -> animationInAction.godSay20(0, speaker, 2000)
            }
            3 -> when (counterStep) {
                12 -> animationInAction.godSay30(1, speaker, 4000)
                26 -> animationInAction.godSay30(0, speaker, 4000)
                40 -> animationInAction.godSay30(1, speaker, 4000)
                else -> animationInAction.godSay30(0, speaker, 2000)
            }
            4 -> when (counterStep) {
                10 -> animationInAction.godSay40(1, speaker, 1000)
                42 -> animationInAction.godSay40(1, speaker, 1000)

                // -> animationInAction.godSay40(0, speaker, 4000)
                else -> animationInAction.godSay40(0, speaker, 2000)
            }
            5 -> when (counterStep) {
                // -> animationInAction.godSay50(0, speaker, 4000)
                else -> animationInAction.godSay50(0, speaker, 2000)
            }
            6 -> when (counterStep) {
                // -> animationInAction.godSay20(0, speaker, 4000)
                else -> animationInAction.godSay60(3, speaker, 4000)
            }
        }
    }

    private fun manAnimations(speaker: Speaker, arr: List<String>) {
        when (arr.size) {
            1 -> when (counterStep) {
                13 -> animationInAction.manSay10(2, speaker, 1000)
                25 -> animationInAction.manSay10(3, speaker, 4000)
                49 -> animationInAction.manSay10(0, speaker, 4000)
                55 -> animationInAction.manSay10(3, speaker, 2000)
                else -> animationInAction.manSay10(0, speaker, 2000)

            }
            2 -> when (counterStep) {
                11 -> animationInAction.manSay20(3, speaker, 4000)
                15 -> animationInAction.manSay20(3, speaker, 2500)
                17 -> animationInAction.manSay20(3, speaker, 2500)
                23 -> animationInAction.manSay20(2, speaker, 2500)
                25 -> animationInAction.manSay20(3, speaker, 3500)
                37 -> animationInAction.manSay20(3, speaker, 2500)
                59 -> animationInAction.manSay20(1, speaker, 2000)

                else -> animationInAction.manSay20(0, speaker, 2000)

            }
            3 -> when (counterStep) {
                5 -> animationInAction.manSay30(2, speaker, 1000)
                9 -> animationInAction.manSay30(2, speaker, 1000)
                39 -> animationInAction.manSay30(3, speaker, 1500)
                41 -> animationInAction.manSay30(1, speaker, 1500)
                47 -> animationInAction.manSay30(3, speaker, 1500)
                else -> animationInAction.manSay30(0, speaker, 2000)

            }
            4 -> when (counterStep) {
                7 -> animationInAction.manSay40(1, speaker, 1000)
                else -> animationInAction.manSay40(0, speaker, 2000)
            }
            5 -> when (counterStep) {
                3 -> animationInAction.manSay50(3, speaker, 2000)
                27 -> animationInAction.manSay50(2, speaker, 1000)
                43 -> animationInAction.manSay50(3, speaker, 1000)
                else -> animationInAction.manSay50(0, speaker, 2000)
            }
            6 -> when (counterStep) {
                1 -> animationInAction.manSay60(3, speaker, 2000)
                else -> animationInAction.manSay60(0, speaker, 2000)
            }
        }
    }

    private fun regularAnimation() {
        val speaker = speakList[counterStep]
        val kind = speaker.whoSpeake
        val st = speaker.taking
        val arr = st.split("\n")
        val dur = 2000L
        if (kind == "man") {
            when (arr.size) {
                1 -> animationInAction.manSay10(0, speaker, dur)
                2 -> animationInAction.manSay20(0, speaker, dur)
                3 -> animationInAction.manSay30(0, speaker, dur)
                4 -> animationInAction.manSay40(0, speaker, dur)
                5 -> animationInAction.manSay50(0, speaker, dur)
                6 -> animationInAction.manSay60(0, speaker, dur)
            }
        } else {
            when (arr.size) {
                1 -> animationInAction.godSay10(0, speaker, dur)
                2 -> animationInAction.godSay20(0, speaker, dur)
                3 -> animationInAction.godSay30(0, speaker, dur)
                4 -> animationInAction.godSay40(0, speaker, dur)
                5 -> animationInAction.godSay50(0, speaker, dur)
                6 -> animationInAction.godSay60(0, speaker, dur)
            }
        }

    }


    private fun updateTitleSituation(lines: Int) {
        //title_situation.text = "madMode=$manMode round=${(counterStep - 1) / 2}"
        title_situation.text = "LinesNum->$lines"
        //counter_situation.text = "counter=$counterStep"
        counter_situation.text = counterStep.toString()
    }

    /*private fun updateListSpeakerStyle() {

          for (ind in 0 until speakList.size) {
              when (ind) {
                  *//*1, 3,9,11 -> speakerList[ind] = StyleAnim.updateSpeaker1(speakerList[ind])
                2-> speakerList[ind] = StyleAnim.updateSpeaker2(speakerList[ind])    //god
                4, 6 -> speakerList[ind] = StyleAnim.updateSpeaker4(speakerList[ind])  //god
                5 -> speakerList[ind] = StyleAnim.updateSpeaker5(speakerList[ind])
                7 -> speakerList[ind] = StyleAnim.updateSpeaker7(speakerList[ind])
                8 -> speakerList[ind] = StyleAnim.updateSpeaker8(speakerList[ind])
                10 -> speakerList[ind] = StyleAnim.updateSpeaker10(speakerList[ind])*//*
                // 12 -> speakerList[ind] = StyleAnim.updateSpeaker12(speakerList[ind])
               // 12,13,14 -> speakList[ind] = StyleAnim.updateNewStyle(ind,speakList[ind])


            }
            if (ind>11){
                speakList[ind] = StyleAnim.updateNewStyle(ind,speakList[ind])
            }
        }
    }
*/
    /*   private fun operateGoddy(speaker: Speaker) {
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

       private fun operatAnimation() {

           var arr1= arrayListOf<Int>()
            arr1 = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
           if (arr1.contains(counterStep)) {
               when (arr.size) {
                   *//*1 -> animationInAction.manMove20(speaker)
                2, 4, 6, 8 -> animationInAction.godMove11A(speaker)
                3 -> animationInAction.manStatic50(2, speaker)
                5 -> animationInAction.manStatic40(2, speaker)
                7 -> animationInAction.manStatic20(0, speaker)
                9 -> animationInAction.manStatic30(1, speaker)
                10 -> animationInAction.godStatic60(0, speaker)
                11 -> animationInAction.manStatic10(0, speaker)
                12 -> animationInAction.godStatic40(0, speaker)*//*


                6->when(counterStep){
                    1->animationInAction.manStatic60(3,speaker)
                }

            }

        }else{
            regularAnimation()


    } }*/
}




