package com.example.yhaa14.step_1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yhaa14.R
import com.example.yhaa14.step_2.AnimationScreen
import com.example.yhaa14.step_2.AnimationScreen.Companion.STYLE
import com.example.yhaa14.step_2.AnimationScreen.Companion.TALKER
import com.example.yhaa14.utils.Speaker
import com.example.yhaa14.utils.Talker

class MainActivity : AppCompatActivity() {

   // val CURRENT_FILE = "text/text8.txt"
  // val CURRENT_FILE = "text/text10.txt"
   val CURRENT_FILE = "text/text11.txt"
   val STYLE_FILE = "style/style11.txt"


    val ADAM = "-אדם-"
    val GOD = "-אלוהים-"

    lateinit var speakerList: ArrayList<Speaker>
    lateinit var talkerList: ArrayList<Talker>
    var operateList = arrayListOf<List<Int>>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getTalkData()
        getStyleData()
        sendData()
    }
    private fun sendData() {
        val intent = Intent(this, AnimationScreen::class.java)

        intent.putExtra(TALKER, talkerList)
        intent.putExtra(STYLE, operateList)

        startActivity(intent)
    }

    private fun getStyleData() {
        var countStyle=1
        var text = applicationContext.assets.open(STYLE_FILE).bufferedReader().use {
            it.readText()
        }
        text = text.replace("\r", "")
        var list = text.split("#")
        operateList= arrayListOf()
        operateList.add(0, arrayListOf())
        for (element in list){
            if (element!=""){
                var ar = element.split(",")
                operateList.add(
                    countStyle,
                    arrayListOf(
                        ar[0].trim().toInt(),
                        ar[1].trim().toInt(),
                        ar[2].trim().toInt(),
                        ar[3].trim().toInt()
                    )
                )
                countStyle++
            }
        }

    }


    private fun getTalkData() {
        var countItem = 0
        var text = applicationContext.assets.open(CURRENT_FILE).bufferedReader().use {
            it.readText()
        }
        text = text.replace("\r", "")
        var list1 = text.split(ADAM)

       // speakerList = arrayListOf()
        talkerList = arrayListOf()

        var speaker = Speaker()
        var talker = Talker()

        talkerList.add(countItem, talker)

        for (element in list1) {
          //  if (element != "" && element.length > 25) {
            if (element != "") {
                var list2 = element.split(GOD)
                var st1 = improveString(list2[0])
                var st2 = improveString(list2[1])
                countItem++

                talker = Talker()
                talker.whoSpeake = "man"
                st1=st1.trim()
                talker.taking = st1
                talker.num=countItem
                var arr = st1.split("\n")
                talker.lines = arr.size
                talkerList.add(talker)


                countItem++

                talker = Talker()
                talker.whoSpeake = "god"
                talker.taking = st2
                talker.num=countItem
                arr = st2.split("\n")
                talker.lines = arr.size
                talkerList.add(talker)
            }
        }

    }
    private fun improveString(st: String) = st.substring(1, st.length - 1)

    /*fun improveSt(st:String):String{
        var stt1=st.trim()
       *//* var stt=st
        val st1="\n"
        val count = st.count{ st1.contains(it) }
        if (count==1){
            stt=st.replace(st1,"")
        }*//*
        return stt1
    }
*/

   /* private fun getData() {
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

    }*/



}



