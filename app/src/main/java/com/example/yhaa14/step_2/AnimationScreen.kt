package com.example.yhaa14.step_2

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yhaa14.Animation.StyleAnim
import com.example.yhaa14.R
import com.example.yhaa14.step_3.AnimationAction
import com.example.yhaa14.utils.Page
import com.example.yhaa14.utils.Speaker
import com.example.yhaa14.utils.StyleObject
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
    // val CURRENT_SPEAKER = "currentSpeaker"
    val CURRENT_SPEAKER = "currentSpeakertext10"
    lateinit var myPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    var operateList = arrayListOf<List<Int>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_screen)
        myPref = getSharedPreferences(PREFS_NAME, 0)
        editor = myPref.edit()
        counterStep = myPref.getInt(CURRENT_SPEAKER, 1)
        animationInAction = AnimationAction(this, mainLayout)
        buttonZom()

//        editor.putInt(CURRENT_SPEAKER,0)
//        editor.commit()

        @Suppress("UNCHECKED_CAST")
        speakList = intent.getSerializableExtra(SPEAKER) as ArrayList<Speaker>
        @Suppress("UNCHECKED_CAST")
        talkList = intent.getSerializableExtra(TALKER) as ArrayList<Talker>

        createStyleList()      // create the original  styleArray and store it in Page.styleArray

        updateTalkList()

        generalOperation()     // Let's play
    }


    private fun generalOperation() {

        if (counterStep < 1) counterStep = 1

          //counterStep=33            //*********************

        manMode = counterStep % 2 != 0

        val talker = talkList[counterStep]
        updateTitleTalkerSituation(talker)

        if (talker.whoSpeake == "man") {
            animationInAction.manTalk(talker)
        } else {
            animationInAction.godTalk(talker)
        }
    }

    fun initOperateValuetext8() {
        operateList.add(0, arrayListOf(210, 1, 1000))
        operateList.add(1, arrayListOf(210, 3, 4000))
        operateList.add(2, arrayListOf(421, 4, 4000))
        operateList.add(3, arrayListOf(210, 1, 1000))
        operateList.add(4, arrayListOf(422, 1, 1000))
        operateList.add(5, arrayListOf(210, 3, 2000))
        operateList.add(6, arrayListOf(421, 4, 4000))
        operateList.add(7, arrayListOf(220, 2, 1000))
        operateList.add(8, arrayListOf(240, 2, 4000))
        operateList.add(9, arrayListOf(210, 3, 2000))
        operateList.add(10, arrayListOf(280, 0, 4000))

    }

    fun initOperateValuetext10() {
        operateList.add(0, arrayListOf(210, 1, 1000))
        operateList.add(1, arrayListOf(221, 3, 3500))
        operateList.add(2, arrayListOf(402, 4, 4000))
        operateList.add(3, arrayListOf(210, 3, 2000))
        operateList.add(4, arrayListOf(400, 1, 2000))
        operateList.add(5, arrayListOf(210, 3, 2000))
        operateList.add(6, arrayListOf(401, 4, 4000))
        operateList.add(7, arrayListOf(220, 2, 1000))
        operateList.add(8, arrayListOf(240, 2, 2000))
        operateList.add(9, arrayListOf(210, 3, 2000))
        operateList.add(10, arrayListOf(402, 4, 2000))
        operateList.add(11, arrayListOf(210, 3, 2000))
        operateList.add(12, arrayListOf(240, 2, 2000))
        operateList.add(13, arrayListOf(210, 2, 2000))
        operateList.add(14, arrayListOf(281, 4, 3000))
        operateList.add(15, arrayListOf(250, 1, 3000))
        operateList.add(16, arrayListOf(402, 1, 3000))
        operateList.add(17, arrayListOf(210, 3, 2000))
        operateList.add(18, arrayListOf(282, 4, 3000))
        operateList.add(19, arrayListOf(210, 3, 2000))
        operateList.add(20, arrayListOf(403, 4, 3000))
        operateList.add(21, arrayListOf(250, 1, 2000))
        operateList.add(22, arrayListOf(250, 2, 3000))
        operateList.add(23, arrayListOf(210, 3, 2000))
        operateList.add(24, arrayListOf(241, 1, 3000))
        operateList.add(25, arrayListOf(210, 3, 2000))
        operateList.add(26, arrayListOf(241, 1, 3000))
        operateList.add(27, arrayListOf(210, 3, 2000))
        operateList.add(28, arrayListOf(270, 0, 4000))
        operateList.add(29, arrayListOf(210, 3, 2000))
        operateList.add(30, arrayListOf(401, 4, 2000))
        operateList.add(31, arrayListOf(210, 0, 1500))
        operateList.add(32, arrayListOf(410, 0, 1500))
        operateList.add(33, arrayListOf(210, 3, 1500))
        operateList.add(34, arrayListOf(402, 0, 1500))
        operateList.add(35, arrayListOf(210, 3, 2000))
        operateList.add(36, arrayListOf(402, 0, 1500))
        operateList.add(37, arrayListOf(210, 3, 2000))
        operateList.add(38, arrayListOf(240, 1, 2000))
        operateList.add(39, arrayListOf(210, 3, 2000))
        operateList.add(40, arrayListOf(402, 0, 1500))
        operateList.add(41, arrayListOf(210, 3, 2000))
        operateList.add(42, arrayListOf(241, 1, 2000))
        operateList.add(43, arrayListOf(220, 1, 2000))
        operateList.add(43, arrayListOf(220, 1, 2000))
        operateList.add(44, arrayListOf(420, 1, 3000))
        operateList.add(45, arrayListOf(200, 3, 2000))
        operateList.add(46, arrayListOf(420, 1, 3000))
        operateList.add(47, arrayListOf(210, 3, 2000))
        operateList.add(48, arrayListOf(281, 0, 3000))
        operateList.add(49, arrayListOf(210, 0, 2000))
        operateList.add(50, arrayListOf(283, 1, 2000))
        operateList.add(51, arrayListOf(210, 3, 2000))
        operateList.add(52, arrayListOf(400, 3, 2000))
        operateList.add(53, arrayListOf(210, 3, 2000))
        operateList.add(54, arrayListOf(402, 4, 3000))
        operateList.add(55, arrayListOf(210, 3, 2000))
        operateList.add(56, arrayListOf(4021, 0, 3000))
        operateList.add(57, arrayListOf(270, 3, 2000))
        operateList.add(58, arrayListOf(401, 4, 4000))
        operateList.add(59, arrayListOf(210, 2, 2000))
        operateList.add(60, arrayListOf(241, 2, 2000))
        operateList.add(61, arrayListOf(200, 3, 2000))
        operateList.add(62, arrayListOf(240, 0, 3000))

        input(63,"21032500")
        input(64,"24122500")
        input(65,"22012500")
        input(66,"40142500")
        input(67,"21032500")
        input(68,"24022500")
        input(69,"22032500")
        input(70,"28222500")
        input(71,"22022500")
        input(72,"42022500")
        input(73,"22032500")
        input(74,"40242500")
        input(75,"22012500")
        input(76,"40142500")
        input(77,"22012500")
        input(78,"40142500")

    }



    private fun input(speaker: Int,animeStyle: String ) {
        val str1=animeStyle.subSequence(0,3).toString().toInt()
        val str2=animeStyle.subSequence(3,4).toString().toInt()
        val str3=animeStyle.subSequence(4,8).toString().toInt()
        operateList.add(speaker, arrayListOf(str1, str2, str3))
    }


    fun enterValueToTalkList(ind: Int, talker: Talker): Talker {


        if (ind < operateList.size) {

            val item = operateList[ind]
            talker.styleNum = item[0]
            talker.animNum = item[1]
            talker.dur = item[2].toLong()
        } else {
            if (talker.whoSpeake == "man") {
                talker.styleNum = 210
                talker.animNum = 3
                talker.dur = 2000L
            }
            if (talker.whoSpeake == "god") {
                talker.styleNum = 400
                talker.animNum = 2
                talker.dur = 2000L
            }

        }
        return talker
    }

    private fun createStyleList() {
        val m200 = StyleObject(200, "#ffffff", "#000000", 24f, 1, 10, 0, 10, 0)
        val m210 = StyleObject(210, "#000000", "#ffffff", 24f, 1, 10, 0, 10, 0)
        val m211 = StyleObject(211, "#000000", "#bdbdbd", 28f, 1, 10, 5, 10, 5)
        val m220 = StyleObject(220, "#bdbdbd", "#000000", 28f, 1, 10, 5, 10, 5)
        val m221 = StyleObject(221, "#bdbdbd", "#000000", 34f, 1, 10, 5, 10, 5)
        val m222 = StyleObject(222, "#bdbdbd", "#000000", 44f, 1, 10, 5, 10, 5)
        val m230 = StyleObject(230, "#ffebee", "#e91e63", 35f, 1, 80, 0, 80, 0)
        val m240 = StyleObject(240, "none", "#1e88e5", 50f, 1, 10, 20, 10, 20)
        val m241 = StyleObject(241, "none", "#1e88e5", 35f, 1, 10, 20, 10, 20)
        val m250 = StyleObject(250, "none", "#ffffff", 28f, 1, 10, 5, 10, 5)
        val m260 = StyleObject(260, "none", "#44000D", 28f, 1, 20, 20, 20, 20)
        val m270 = StyleObject(270, "#e3f2fd", "#44000D", 28f, 1, 10, 20, 10, 20)
        val m280 = StyleObject(280, "none", "#6ff9ff", 28f, 1, 10, 5, 10, 0)
        val m281 = StyleObject(281, "none", "#6ff9ff", 80f, 1, 10, 5, 10, 0)
        val m282 = StyleObject(282, "none", "#6ff9ff", 50f, 1, 10, 5, 10, 0)
        val m283 = StyleObject(283, "none", "#6ff9ff", 30f, 1, 10, 5, 10, 0)
        //val m11 = StyleObject()
        val m400 = StyleObject(400, "none", "#f9a825", 28f, 1, 10, 80, 10, 20)
        val m401 = StyleObject(401, "none", "#f9a825", 80f, 1, 10, 80, 10, 20)
        val m402 = StyleObject(402, "none", "#f9a825", 160f, 1, 10, 80, 10, 20)
        val m4021 = StyleObject(4021, "none", "#f9a825", 100f, 1, 10, 0, 10, 0)
        val m403 = StyleObject(403, "none", "#f9a825", 210f, 1, 10, 80, 10, 20)
        val m410 = StyleObject(410, "#e3f2fd", "#1e88e5", 28f, 1, 10, 5, 10, 5)
        val m420 = StyleObject(420, "#e3f2fd", "#f9a825", 28f, 1, 10, 20, 10, 20)


        var list = listOf<StyleObject>(
            m200,
            m210,
            m211,
            m220,
            m221,
            m222,
            m230,
            m240,
            m241,
            m250,
            m260,
            m270,
            m280,
            m281,
            m282,m283,
            m400,
            m401,
            m402,m4021,
            m403,
            m410,m420
        )
        Page.styleArray.addAll(list)
    }


    private fun updateTalkList() {
        initOperateValuetext10()
        for (ind in 1 until talkList.size) {
            talkList[ind] = enterValueToTalkList(ind, talkList[ind])
        }

    }

    private fun updateTitleTalkerSituation(talker: Talker) {

        var st = talker.taking
        val arr = st.split("\n")
        val lines = arr.size
        //title_situation.text = "LinesNum->$lines"
        // counter_situation.text = counterStep.toString()
        val text =
            ">${counterStep}< NumLine->$lines style->${talker.styleNum} anim->${talker.animNum} duration->${talker.dur} ${talker.whoSpeake}"
        tvAnimatinKind.text = text
    }

// 2->{talker.styleNum=421;talker.animNum=4;talker.dur=4000}


    private fun buttonZom() {

        goddy.setOnClickListener {
            if (manMode) {
                counterStep++
                generalOperation()
            } else {
                Toast.makeText(this, "נסה שוב, זה התור של האדם לדבר", Toast.LENGTH_LONG).show()
            }
        }

        man.setOnClickListener {
            if (!manMode) {
                counterStep++
                generalOperation()
            } else {
                Toast.makeText(this, "נסה שוב, זה התור של האין סוף להגיב", Toast.LENGTH_LONG).show()
            }
        }
        nextButton.setOnClickListener {
            counterStep++
            generalOperation()
        }
        previousButton.setOnClickListener {
            counterStep--
            if (counterStep < 1) counterStep = 1
            generalOperation()
        }
        saveButton.setOnClickListener {
            editor.putInt(CURRENT_SPEAKER, counterStep)
            editor.commit()
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
        }
        return style1
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




