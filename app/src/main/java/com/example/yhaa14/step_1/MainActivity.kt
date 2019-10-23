package com.example.yhaa14.step_1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yhaa14.R
import com.example.yhaa14.step_2.AnimationScreen
import com.example.yhaa14.step_2.AnimationScreen.Companion.SPEAKER
import com.example.yhaa14.step_2.AnimationScreen.Companion.TALKER
import com.example.yhaa14.utils.Speaker
import com.example.yhaa14.utils.Talker

class MainActivity : AppCompatActivity() {

   // val CURRENT_FILE = "text/text8.txt"
  // val CURRENT_FILE = "text/text10.txt"
   val CURRENT_FILE = "text/text11.txt"


    val ADAM = "-אדם-"
    val GOD = "-אלוהים-"

    lateinit var speakerList: ArrayList<Speaker>
    lateinit var talkerList: ArrayList<Talker>
    private var counter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
        getTalkData()
        sendData()
    }


    private fun sendData() {
        val intent1 = Intent(this, AnimationScreen::class.java)


        intent1.putExtra(SPEAKER, speakerList)

        intent1.putExtra(TALKER, talkerList)

        // intent1.putExtra(COUNTER, counter - 1)

        startActivity(intent1)
    }

    private fun getTalkData() {
        var countItem = 0
        var text = applicationContext.assets.open(CURRENT_FILE).bufferedReader().use {
            it.readText()
        }
        text = text.replace("\r", "")
        var list1 = text.split(ADAM)

        speakerList = arrayListOf()
        talkerList = arrayListOf()

        var speaker = Speaker()
        var talker = Talker()

        speakerList.add(countItem, speaker)
        talkerList.add(countItem, talker)

        for (element in list1) {
          //  if (element != "" && element.length > 25) {
            if (element != "") {
                var list2 = element.split(GOD)
                var st1 = improveString(list2[0])
                var st2 = improveString(list2[1])
                countItem++

                speaker = Speaker()
                speaker.whoSpeake = "man"
                speaker.taking = st1
                speakerList.add(countItem, speaker)

                talker = Talker()
                talker.whoSpeake = "man"
                st1=improveSt(st1)
                talker.taking = st1
                talkerList.add(talker)

                countItem++

                speaker = Speaker()
                speaker.whoSpeake = "god"
                speaker.taking = st2
                st2=improveSt(st2)
                speakerList.add(countItem, speaker)

                talker = Talker()
                talker.whoSpeake = "god"
                talker.taking = st2
                talkerList.add(talker)
            }
        }

    }
    fun improveSt(st:String):String{
        var stt1=st.trim()
       /* var stt=st
        val st1="\n"
        val count = st.count{ st1.contains(it) }
        if (count==1){
            stt=st.replace(st1,"")
        }*/
        return stt1
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

    /* private fun updateListSpeakerStyle() {
         *//*var arr1 = arrayListOf<Int>()
        arr1 = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8)*//*
        for (ind in 0 until speakerList.size) {
            when (ind) {
                1, 3,9,11 -> speakerList[ind] = StyleAnim.updateSpeaker1(speakerList[ind])
                2-> speakerList[ind] = StyleAnim.updateSpeaker2(speakerList[ind])    //god
                4, 6 -> speakerList[ind] = StyleAnim.updateSpeaker4(speakerList[ind])  //god
                5 -> speakerList[ind] = StyleAnim.updateSpeaker5(speakerList[ind])
                7 -> speakerList[ind] = StyleAnim.updateSpeaker7(speakerList[ind])
                8 -> speakerList[ind] = StyleAnim.updateSpeaker8(speakerList[ind])
                10 -> speakerList[ind] = StyleAnim.updateSpeaker10(speakerList[ind])
               // 12 -> speakerList[ind] = StyleAnim.updateSpeaker12(speakerList[ind])
                12,13 -> speakerList[ind] = StyleAnim.updateNewStyle(ind,speakerList[ind])
            }
            *//*if (arr1.contains(ind)) {
                speakerList[ind].config = true
            }*//*
        }
    }*/
}



