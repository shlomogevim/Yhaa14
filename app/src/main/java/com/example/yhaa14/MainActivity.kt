package com.example.yhaa14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yhaa14.AnimationScreen.Companion.COUNTER
import com.example.yhaa14.AnimationScreen.Companion.SPEAKER

class MainActivity : AppCompatActivity() {

    val ADAM = "-אדם-"
    val GOD = "-אלוהים-"

    lateinit var speakerList: ArrayList<Speaker>
    private var counter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
        updateListSpeaker()
        sendData()
    }

    private fun updateListSpeaker() {

        counter = 0

        for (ind in 0 until speakerList.size)


            when (ind) {
                2, 4, 6,8 -> speakerList[ind] = updateSpeaker2(speakerList[ind])
                5,8 -> speakerList[ind] = updateSpeaker5(speakerList[ind])
                7 -> speakerList[ind] = updateSpeaker7(speakerList[ind])
                9 -> speakerList[ind] = updateSpeaker9(speakerList[ind])
                10 -> speakerList[ind] = updateSpeaker10(speakerList[ind])
                12 -> speakerList[ind] = updateSpeaker12(speakerList[ind])
                14 -> speakerList[ind] = updateSpeaker14(speakerList[ind])
            }
    }
    private fun updateSpeaker14(speaker: Speaker): Speaker {
        speaker.colorText = "#bdbdbd"
        speaker.colorBack = "#f54291"
        speaker.sizeText = 16f
        speaker.styleText = 1
        speaker.paddingTop = 30
        speaker.paddingButton = 5
        return speaker
    }

    private fun updateSpeaker12(speaker: Speaker): Speaker {
        speaker.colorText = "#3e64ff"
        // speaker.colorBack = "#ecfcff"
        speaker.colorBack = "#ffffff"
        speaker.sizeText = 35f
        speaker.styleText = 1
        speaker.paddingTop = 10
        // speaker.paddingButton = 30
        return speaker
    }
    private fun updateSpeaker10(speaker: Speaker): Speaker {
        speaker.colorText = "#3e64ff"
        // speaker.colorBack = "#ecfcff"
        speaker.colorBack = "#ffffff"
        speaker.sizeText = 21f
        speaker.styleText = 1
        speaker.paddingTop = 10
        speaker.paddingRight = 5
        speaker.paddingLeft = 5
        // speaker.paddingButton = 30
        return speaker
    }
    private fun updateSpeaker9(speaker: Speaker): Speaker {
        // speaker.colorText = "#3e64ff"
        // speaker.colorBack = "#ecfcff"
        speaker.sizeText = 21f
        speaker.styleText = 1
        speaker.paddingTop = 10
        // speaker.paddingButton = 30
        return speaker
    }

    private fun updateSpeaker7(speaker: Speaker): Speaker {
        // speaker.colorText = "#bdbdbd"
        //  speaker.colorBack = "#44000D"
        speaker.sizeText = 32f
        speaker.styleText = 3
        // speaker.paddingTop = 50
        //  speaker.paddingButton = 30
        return speaker
    }
    private fun updateSpeaker2(speaker: Speaker): Speaker {
        speaker.colorText = "#bdbdbd"
        speaker.colorBack = "#44000D"
        speaker.sizeText = 28f
        speaker.styleText = 1
        speaker.paddingTop = 50
        speaker.paddingButton = 30
        return speaker
    }

    private fun updateSpeaker5(speaker: Speaker): Speaker {
        //speaker.colorText = "#C70D3A"
        //speaker.colorBack = "#40BFC1"
        speaker.sizeText = 22f
        speaker.styleText = 0
        //speaker.paddingTop = 0
        // speaker.paddingButton = 0
        return speaker
    }


    private fun sendData() {
        val intent1 = Intent(this, AnimationScreen::class.java)


        intent1.putExtra(SPEAKER, speakerList)
        intent1.putExtra(COUNTER, counter - 1)

        startActivity(intent1)
    }

    private fun getData() {
        var count = 0
        var text = applicationContext.assets.open("text10.txt").bufferedReader().use {
            it.readText()
        }
        text = text.replace("\r", "")
        var list1 = text.split(ADAM)
        speakerList = arrayListOf()
        var speaker = Speaker()
        speakerList.add(count, speaker)
        for (element in list1) {
            if (element != "" && element.length > 15) {
                var list2 = element.split(GOD)
                val st1 = improveString(list2[0])
                val st2 = improveString(list2[1])
                count++
                speaker = Speaker()
                speaker.whoSpeake = "man"
                speaker.taking = st1
                speakerList.add(count, speaker)
                count++
                speaker = Speaker()
                speaker.whoSpeake = "god"
                speaker.taking = st2
                speakerList.add(count, speaker)
            }
        }

    }

    private fun improveString(st: String) = st.substring(1, st.length - 1)
}

