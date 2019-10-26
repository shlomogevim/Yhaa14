package com.example.yhaa14.step_2

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yhaa14.R
import com.example.yhaa14.step_3.AnimationAction
import com.example.yhaa14.step_3.AnimationAction1
import com.example.yhaa14.utils.*
import kotlinx.android.synthetic.main.activity_animation_screen.*
import kotlinx.android.synthetic.main.current_position_layout.*
import kotlinx.android.synthetic.main.god_layout.*
import kotlinx.android.synthetic.main.man_layout.*


class AnimationScreen : AppCompatActivity() {
    companion object {
        const val TALKER = "talker"
        const val STYLE = "style"
    }

    lateinit var talkList: ArrayList<Talker>
    lateinit var operateList:ArrayList<List<Int>>


    private var manMode = true
    private var counterStep = 1

    lateinit var animationInAction1: AnimationAction1

    val PREFS_NAME = "myPrefs"
    val CURRENT_SPEAKER = "currentSpeakertext10"
    lateinit var myPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_screen)
        myPref = getSharedPreferences(PREFS_NAME, 0)
        editor = myPref.edit()
        counterStep = myPref.getInt(CURRENT_SPEAKER, 1)
        animationInAction1 = AnimationAction1(this, mainLayout)
        buttonZom()

        @Suppress("UNCHECKED_CAST")
        talkList = intent.getSerializableExtra(TALKER) as ArrayList<Talker>
        @Suppress("UNCHECKED_CAST")
        operateList=intent.getSerializableExtra(STYLE) as ArrayList<List<Int>>

        Page.createBasicStyle()

        updateTalkList()

        generalOperation()     // Let's play
    }


    private fun generalOperation() {

        if (counterStep < 1) counterStep = 1

            // counterStep = 1           //*********************

        manMode = counterStep % 2 != 0

        val talker = talkList[counterStep]
        updateTitleTalkerSituation(talker)

        if (talker.whoSpeake == "man") {
            animationInAction1.manTalk(talker)
        } else {
            animationInAction1.godTalk(talker)
        }
    }



    fun enterValueToTalkList(ind: Int, talker: Talker): Talker {
        if (ind < operateList.size) {
            val item = operateList[ind]
            talker.styleNum = item[0]
            talker.animNum = item[1]
            talker.dur = item[2].toLong()
            talker.textSize = item[3].toFloat()
        } else {
            if (talker.whoSpeake == "man") {
                talker.styleNum = 210
                talker.animNum = 3
                talker.dur = 2000L
                talker.textSize = 28f
            }
            if (talker.whoSpeake == "god") {
                talker.styleNum = 400
                talker.animNum = 2
                talker.dur = 2000L
                talker.textSize = 48f
            }
        }
        return talker
    }


    private fun updateTalkList() {
            //   operateList = FileStyling.initFileText11()
        for (ind in 1 until talkList.size) {
            talkList[ind] = enterValueToTalkList(ind, talkList[ind])
        }
    }
// the idea is to isolate the text item from the style item for ease to correct them

    private fun updateTitleTalkerSituation(talker: Talker) {

        var st = talker.taking
        val arr = st.split("\n")
        val lines = arr.size
        val text =
            ">${talker.num}< NumL->$lines style->${talker.styleNum} anim->${talker.animNum} dur->${talker.dur} ${talker.whoSpeake}"
        tvAnimatinKind.text = text
    }


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
    /* private fun createStyleList() {
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
           m200, m210, m211,
           m220, m221, m222,
           m230,
           m240, m241,
           m250,
           m260,
           m270,
           m280, m281, m282, m283,
           m400, m401, m402, m4021, m403,
           m410, m420
       )
       Page.styleArray.addAll(list)
   }
*/
    /* fun initOperateValuetext8() {
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

        }*/
    /* fun initFileText10() {
         var para = ""
         for (counter in 0..78) {
             when (counter) {
                 0 -> para = "210, 1, 1000,28"
                 1 -> para = "221, 3, 3500,34"
                 2 -> para = "402, 4, 4000,160"
                 3 -> para = "210, 3, 2000,24"
                 4 -> para = "400, 1, 2000,28"
                 5 -> para = "210, 3, 2000,24"
                 6 -> para = "401, 1, 2000,80"
                 7 -> para = "220, 2, 1000,20"
                 8 -> para = "240, 2, 2000,20"
                 9 -> para = "210, 3, 2000,24"
                 10 -> para = "240, 2, 2000,20"
                 11 -> para = "210, 3, 2000,24"
                 12 -> para = "240, 2, 2000,20"
                 13 -> para = "210, 2, 2000,28"
                 14 -> para = "281, 4, 3000,80"
                 15 -> para = "250, 1, 3000,28"
                 16 -> para = "402, 1, 3000,160"
                 17 -> para = "210, 3, 2000,24"
                 18 -> para = "282, 4, 3000,50"
                 19 -> para = "210, 3, 2000,24"
                 20 -> para = "403, 4, 3000,210"
                 21 -> para = "250, 1, 3000,28"
                 22 -> para = "250, 2, 3000,28"
                 23 -> para = "210, 3, 2000,24"
                 25 -> para = "210, 3, 2000,24"
                 24 -> para = "241, 1, 3000,35"
                 26 -> para = "241, 1, 3000,35"
                 27 -> para = "210, 3, 2000,24"
                 28 -> para = "270, 0, 4000,28"
                 29 -> para = "210, 3, 2000,24"
                 30 -> para = "401, 1, 2000,80"
                 31 -> para = "210, 0, 1500,28"
                 32 -> para = "410, 0, 1500,28"
                 33 -> para = "210, 3, 2000,24"
                 34 -> para = "402, 0, 1500,160"
                 35 -> para = "210, 3, 2000,24"
                 36 -> para = "402, 0, 1500,160"
                 37 -> para = "210, 3, 2000,24"
                 38 -> para = "240, 1, 2000,20"
                 39 -> para = "210, 3, 2000,24"
                 40 -> para = "402, 0, 1500,160"
                 41 -> para = "210, 3, 2000,28"
                 42 -> para = "241, 1, 3000,35"
                 43 -> para = "220, 1, 2000,20"
                 44 -> para = "420, 1, 3000,28"
                 45 -> para = "200, 3, 2000,24"
                 46 -> para = "420, 1, 3000,28"
                 47 -> para = "210, 3, 2000,24"
                 48 -> para = "281, 4, 3000,80"
                 49 -> para = "210, 0, 1500,28"
                 50 -> para = "283, 1, 2000,30"
                 51 -> para = "210, 3, 2000,28"
                 52 -> para = "400, 3, 2000,28"
                 53 -> para = "210, 3, 2000,28"
                 54 -> para = "402, 4, 3000,160"
                 55 -> para = "210, 3, 2000,28"
                 56 -> para = "4021, 0, 3000,1000"
                 57 -> para = "270, 3, 2000,28"
                 58 -> para = "401, 4, 4000,80"
                 59 -> para = "210, 2, 2000,28"
                 60 -> para = "241, 2, 2000,35"
                 61 -> para = "200, 3, 2000,28"
                 62 -> para = "240, 0, 3000,28"
                 63 -> para = "210,3,2500,24"
                 64 -> para = "241,2,2500,35"
                 65 -> para = "220,1,2500,20"
                 66 -> para = "401,4,2500,80"
                 67 -> para = "210,3,2500,28"
                 68 -> para = "240,2,2500,28"
                 69 -> para = "220,3,2500,28"
                 70 -> para = "282,2,2500,50"
                 71 -> para = "220,2,2500,20"
                 72 -> para = "420,2,2500,20"
                 73 -> para = "220,3,2500,28"
                 74 -> para = "402,4,2500,160"
                 75 -> para = "220,1,2500,28"
                 76 -> para = "401,4,2500,80"
                 77 -> para = "220,1,2500,28"
                 78 -> para = "401,4,2500,80"
                 else -> para = "210, 1, 1000,28"
             }
             var ar = para.split(",")
             operateList1.add(
                 counter,
                 arrayListOf(
                     ar[0].trim().toInt(),
                     ar[1].trim().toInt(),
                     ar[2].trim().toInt(),
                     ar[3].trim().toInt()
                 )
             )

         }*/
    /*fun initFileText11() {
       var para = ""
       for (counter in 0..100) {
           when (counter) {
               0 -> para = "210, 1, 1000,28"
               1 -> para = "221, 3, 3500,34"
               2 -> para = "402, 4, 4000,160"
               3 -> para = "210, 3, 2000,24"
               4 -> para = "400, 1, 2000,160"
               5 -> para = "210, 3, 2000,24"
               6 -> para = "401, 1, 4000,80"
               7 -> para = "220, 2, 2000,20"
               8 -> para = "240, 2, 4000,80"
               9 -> para = "210, 3, 2000,24"
               10 -> para = "240, 4, 4000,60"
               11 -> para = "210, 3, 2000,24"
               12 -> para = "240, 2, 4000,50"
               13 -> para = "210, 2, 2000,28"
               14 -> para = "281, 4, 3000,80"
               15 -> para = "250, 0, 3000,28"
               16 -> para = "402, 1, 3000,50"
               17 -> para = "210, 3, 2000,24"
               18 -> para = "282, 4, 3000,50"
               19 -> para = "210, 3, 2000,24"
               20 -> para = "270, 1, 3000,50"
               21 -> para = "250, 1, 3000,28"
               22 -> para = "270, 1, 3000,50"
               23 -> para = "210, 3, 2000,24"
               25 -> para = "210, 3, 2000,24"
               24 -> para = "241, 1, 3000,35"
               26 -> para = "270, 1, 3000,35"
               27 -> para = "210, 3, 2000,24"
               28 -> para = "240, 0, 4000,50"
               29 -> para = "210, 3, 2000,24"
               30 -> para = "210, 1, 2000,30"
               31 -> para = "200, 0, 1500,24"
               32 -> para = "410, 0, 3500,50"
               33 -> para = "210, 3, 2000,24"
               34 -> para = "240, 1, 2500,35"
               35 -> para = "210, 1, 1500,35"
               36 -> para = "240, 1, 1500,35"
               37 -> para = "210, 3, 2000,24"
               38 -> para = "230, 1, 2000,30"
               39 -> para = "210, 3, 2000,24"
               40 -> para = "280, 0, 4000,30"
               41 -> para = "210, 3, 2000,28"
               42 -> para = "420, 1, 3000,30"
               43 -> para = "220, 3, 2000,30"
               44 -> para = "420, 1, 3000,28"
               45 -> para = "200, 3, 2000,24"
               46 -> para = "420, 1, 3000,28"
               47 -> para = "210, 3, 2000,24"
               48 -> para = "281, 0, 3000,40"
               49 -> para = "210, 0, 1500,28"
               50 -> para = "400, 4, 4000,150"
               51 -> para = "210, 0, 2000,25"
               52 -> para = "400, 3, 4000,180"
               53 -> para = "210, 1, 2000,28"
               54 -> para = "402, 4, 3000,160"
               55 -> para = "210, 3, 2000,28"
               56 -> para = "280, 0, 3000,50"
               57 -> para = "270, 3, 2000,28"
               58 -> para = "250, 0, 4000,35"
               59 -> para = "210, 3, 2000,38"
               60 -> para = "241, 4, 4000,150"
               61 -> para = "200, 3, 2000,28"
               62 -> para = "240, 0, 3000,120"
               63 -> para = "210,3,2500,24"
               64 -> para = "241,2,2500,35"
               65 -> para = "220,3,2500,50"
               66 -> para = "240,0,2500,40"
               67 -> para = "210,3,2500,28"
               68 -> para = "270,2,3500,28"
               69 -> para = "220,3,2500,28"
               70 -> para = "282,2,2500,50"
               71 -> para = "220,2,2500,25"
               72 -> para = "420,2,2500,25"
               73 -> para = "220,3,2500,28"
               74 -> para = "402,0,2500,60"
               75 -> para = "220,1,2500,28"
               76 -> para = "270,2,2500,30"
               77 -> para = "220,3,2500,28"
               78 -> para = "401,4,2500,180"
               79 -> para = "220,3,2500,28"
               80 -> para = "282,2,2500,50"
               81 -> para = "220,2,2500,25"
               82 -> para = "420,3,2500,185"
               83 -> para = "220,3,2500,28"
               84 -> para = "402,0,2500,100"

               else -> para = "210, 1, 1000,28"
           }
           var ar = para.split(",")
           operateList1.add(
               counter,
               arrayListOf(
                   ar[0].trim().toInt(),
                   ar[1].trim().toInt(),
                   ar[2].trim().toInt(),
                   ar[3].trim().toInt()
               )
           )

       }

   }
*/

}







