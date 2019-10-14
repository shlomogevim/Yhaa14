package com.example.yhaa14.step_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yhaa14.step_2.AnimationScreen
import com.example.yhaa14.step_2.AnimationScreen.Companion.COUNTER
import com.example.yhaa14.step_2.AnimationScreen.Companion.SPEAKER
import com.example.yhaa14.R
import com.example.yhaa14.utils.Speaker
import com.example.yhaa14.Animation.StyleAnim

class MainActivity : AppCompatActivity() {


    val CURRENT_FILE="text30.txt"
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


    private fun sendData() {
        val intent1 = Intent(this, AnimationScreen::class.java)


        intent1.putExtra(SPEAKER, speakerList)
        intent1.putExtra(COUNTER, counter - 1)

        startActivity(intent1)
    }

    private fun getData() {
        var count = 0
        var text = applicationContext.assets.open(CURRENT_FILE).bufferedReader().use {
            it.readText()
        }
        text = text.replace("\r", "")
        var list1 = text.split(ADAM)
        speakerList = arrayListOf()
        var speaker = Speaker()
        speakerList.add(count, speaker)
        for (element in list1) {
            if (element != "" && element.length > 25) {
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

    private fun updateListSpeaker() {

        for (ind in 0 until speakerList.size)
            when (ind) {
                1,3->speakerList[ind]= StyleAnim.updateSpeaker1(speakerList[ind])
                2 -> speakerList[ind] = StyleAnim.updateSpeaker2(speakerList[ind])    //god
                4,6 -> speakerList[ind] = StyleAnim.updateSpeaker4(speakerList[ind])  //god
                5 -> speakerList[ind] = StyleAnim.updateSpeaker5(speakerList[ind])
                7 -> speakerList[ind] = StyleAnim.updateSpeaker7(speakerList[ind])
                8 -> speakerList[ind] = StyleAnim.updateSpeaker8(speakerList[ind])
            }
    }
}



