package com.example.yhaa14.Animation

import com.example.yhaa14.utils.Speaker
import com.example.yhaa14.utils.Talker

object StyleAnim {

    /*fun updateNewTalkerStyle(talker: Talker): Talker {

        var talker1 = Talker()

        if (talker.whoSpeake == "god") {
            talker1 = updateGodTalkStyle(talker)
        } else {
            talker1 = updateManTalkStyle(talker)
        }

        return talker1
    }*/

    private fun updateManTalkStyle(talker: Talker): Talker {
       /* with(talker) {
            when (counter) {
                1 -> {
                    styleNum = 100
                    animNum=10
                }
                else -> {
                    styleNum = 100
                    animNum=10
                }
            }
        }*/
        return talker
    }

    private fun updateGodTalkStyle(talker: Talker): Talker {
        /*with(talker) {
            when (counter) {
                1 -> {
                    styleNum = 200
                    animNum=20
                }
                else -> {
                    styleNum = 200
                    animNum=20
                }
            }
        }*/
        return talker
    }


    /*fun updateNewStyle(counter: Int, speaker: Speaker): Speaker {
        var speaker1 = Speaker()

        if (speaker.whoSpeake == "god") {
            speaker1 = updateGodStyle(counter, speaker)
        } else {
            speaker1 = updateManStyle(counter, speaker)

        }
        return speaker1
    }
*/

    private fun getGodContant(styleVersion: Int, speaker: Speaker) {
        when (styleVersion) {
            100 -> makeStyle(speaker, "none", "#1e88e5", 60f, 1, 10, 20, 10, 20)
            101 -> makeStyle(speaker, "none", "#1e88e5", 45f, 1, 10, 20, 10, 20)
            110 -> makeStyle(speaker, "none", "#f9a825", 140f, 1, 10, 80, 10, 20)
            111 -> makeStyle(speaker, "none", "#f9a825", 80f, 1, 10, 80, 10, 20)
            112 -> makeStyle(speaker, "none", "#f9a825", 30f, 1, 10, 80, 10, 20)
            120 -> makeStyle(speaker, "none", "#44000D", 40f, 1, 20, 20, 20, 20)
            130 -> makeStyle(speaker, "#e3f2fd", "#1e88e5", 28f, 1, 10, 5, 10, 10)
            140 -> makeStyle(speaker, "none", "#6ff9ff", 36f, 1, 10, 5, 10, 0)
            141 -> makeStyle(speaker, "none", "#6ff9ff", 26f, 1, 10, 5, 10, 0)
        }
    }

    private fun updateGodStyle(counter: Int, speaker: Speaker): Speaker {
        when (counter) {

            2 -> getGodContant(100, speaker)
            4 -> getGodContant(110, speaker)
            6 -> getGodContant(110, speaker)
            8 -> getGodContant(120, speaker)
            10 -> getGodContant(130, speaker)
            12 -> getGodContant(140, speaker)
            14 -> getGodContant(141, speaker)
            16 -> getGodContant(101, speaker)
            18 -> getGodContant(110, speaker)
            20 -> getGodContant(120, speaker)
            22 -> getGodContant(120, speaker)
            24 -> getGodContant(100, speaker)
            26 -> getGodContant(120, speaker)
            28 -> getGodContant(100, speaker)
            30 -> getGodContant(120, speaker)
            32 -> getGodContant(100, speaker)
            34 -> getGodContant(140, speaker)
            36 -> getGodContant(130, speaker)
            38 -> getGodContant(111, speaker)
            40 -> getGodContant(120, speaker)
            42 -> getGodContant(120, speaker)
            44 -> getGodContant(111, speaker)
            46 -> getGodContant(130, speaker)
            48 -> getGodContant(100, speaker)
            50 -> getGodContant(130, speaker)
            52 -> getGodContant(100, speaker)
            54 -> getGodContant(111, speaker)
            56 -> getGodContant(110, speaker)
            58 -> getGodContant(100, speaker)
            60 -> getGodContant(110, speaker)
        }
        return speaker
    }

    private fun getManContant(styleVersion: Int, speaker: Speaker) {
        when (styleVersion) {
            100 -> makeStyle(speaker, "#ffffff", "#000000", 24f, 1, 10, 0, 10, 0)
            110 -> makeStyle(speaker, "#000000", "#bdbdbd", 28f, 1, 10, 5, 10, 5)
            120 -> makeStyle(speaker, "#ffebee", "#e91e63", 35f, 1, 80, 0, 80, 0)
            130 -> makeStyle(speaker, "none", "#1e88e5", 60f, 1, 10, 20, 10, 20)
            131 -> makeStyle(speaker, "none", "#ffffff", 30f, 1, 10, 5, 10, 5)
            140 -> makeStyle(speaker, "none", "#f9a825", 140f, 1, 10, 80, 10, 20)
            150 -> makeStyle(speaker, "none", "#44000D", 40f, 1, 20, 20, 20, 20)
            151 -> makeStyle(speaker, "#e3f2fd", "#44000D", 40f, 1, 10, 20, 10, 20)
            152 -> makeStyle(speaker, "none", "#ffffff", 28f, 1, 10, 20, 10, 20)
            153 -> makeStyle(speaker, "none", "#44000D", 28f, 1, 20, 20, 20, 20)
            160 -> makeStyle(speaker, "#e3f2fd", "#1e88e5", 28f, 1, 10, 5, 10, 10)
            170 -> makeStyle(speaker, "none", "#6ff9ff", 36f, 1, 10, 5, 10, 0)
            171 -> makeStyle(speaker, "none", "#6ff9ff", 26f, 1, 10, 5, 10, 0)

        }
    }

    private fun updateManStyle(counter: Int, speaker: Speaker): Speaker {
        when (counter) {
            1 -> getManContant(110, speaker)
            3 -> getManContant(110, speaker)
            5 -> getManContant(120, speaker)
            7 -> getManContant(110, speaker)
            9 -> getManContant(110, speaker)
            11 -> getManContant(110, speaker)
            13 -> getManContant(100, speaker)
            15 -> getManContant(100, speaker)
            17 -> getManContant(110, speaker)
            19 -> getManContant(151, speaker)
            21 -> getManContant(170, speaker)
            23 -> getManContant(150, speaker)
            25 -> getManContant(151, speaker)
            27 -> getManContant(151, speaker)
            29 -> getManContant(170, speaker)
            31 -> getManContant(170, speaker)
            33 -> getManContant(110, speaker)
            35 -> getManContant(160, speaker)
            37 -> getManContant(100, speaker)
            39 -> getManContant(110, speaker)
            41 -> getManContant(152, speaker)
            43 -> getManContant(120, speaker)
            45 -> getManContant(152, speaker)
            47 -> getManContant(131, speaker)
            49 -> getManContant(170, speaker)
            51 -> getManContant(131, speaker)
            53 -> getManContant(131, speaker)
            55 -> getManContant(110, speaker)
            57 -> getManContant(170, speaker)
            59 -> getManContant(170, speaker)

        }
        return speaker
    }


    fun makeStyle(
        speaker: Speaker,
        colorBack: String,
        colorText: String,
        sizeText: Float,
        styleText: Int,
        paddingLeft: Int,
        paddingTop: Int,
        paddingRight: Int,
        paddingButton: Int
    ): Speaker {
        speaker.colorBack = colorBack
        speaker.colorText = colorText
        speaker.sizeText = sizeText
        speaker.styleText = styleText
        speaker.paddingLeft = paddingLeft
        speaker.paddingTop = paddingTop
        speaker.paddingRight = paddingRight
        speaker.paddingButton = paddingButton
        return speaker
    }


    /* fun updateSpeaker1(speaker: Speaker): Speaker {
         with(speaker) {
             colorText = "#bdbdbd"
             colorBack = "#000000"
             sizeText = 20f
             styleText = 0
             paddingLeft = 10
             paddingTop = 0
             paddingRight = 10
             paddingButton = 0
         }
         return speaker
     }*/

    /* fun updateSpeaker2(speaker: Speaker): Speaker {
         speaker.colorText = "#44000D"
         speaker.sizeText = 50f
         speaker.styleText = 1
         speaker.paddingTop = 20
         speaker.paddingButton = 20
         return speaker
     }*/

    /* fun updateSpeaker4(speaker: Speaker): Speaker {
         speaker.colorText = "#f9a825"
         speaker.sizeText = 140f
         speaker.styleText = 1
         speaker.paddingTop = 80
         return speaker
     }*/

    /*  fun updateSpeaker5(speaker: Speaker): Speaker {
          with(speaker) {
              colorText = "#e91e63"
              colorBack = "#ffebee"
              sizeText = 35f
              styleText = 1
              paddingLeft = 80
              paddingTop = 0
              paddingRight = 80
              paddingButton = 0
          }
          return speaker
      }*/

    /* fun updateSpeaker7(speaker: Speaker): Speaker {
         with(speaker) {
             colorText = "#bdbdbd"
             colorBack = "#000000"
             sizeText = 30f
             styleText = 0
             paddingLeft = 30
             paddingTop = 0
             paddingRight = 30
             paddingButton = 0
         }
         return speaker
     }*/


    /* fun updateSpeaker8(speaker: Speaker): Speaker {
         speaker.colorText = "#44000D"
         speaker.sizeText = 40f
         speaker.styleText = 1
         speaker.paddingTop = 20
         speaker.paddingButton = 20
         return speaker
     }*/

    /*  fun updateSpeaker10(speaker: Speaker): Speaker {
          with(speaker) {
              colorBack = "#e3f2fd"
              colorText = "#1e88e5"
              sizeText = 28f
              styleText = 1
              paddingTop = 5
              paddingButton = 0
              paddingRight = 10
              paddingLeft = 10
          }
          return speaker
      }*/

    /* fun updateSpeaker11(speaker: Speaker): Speaker {
         with(speaker) {
             colorBack = "#e3f2fd"
             colorText = "#1e88e5"
             sizeText = 28f
             styleText = 1
             paddingTop = 5
             paddingButton = 0
             paddingRight = 10
             paddingLeft = 10
         }
         return speaker
     }*/

    /* fun updateSpeaker12(speaker: Speaker): Speaker {
         with(speaker) {
             //colorBack = "#e3f2fd"
             colorText = "#6ff9ff"
             sizeText = 34f
             styleText = 1
             paddingTop = 5
             paddingButton = 0
             paddingRight = 10
             paddingLeft = 10
         }
         return speaker
     }*/

    /* fun updateSpeaker13(speaker: Speaker): Speaker {
         with(speaker) {
             colorText = "#bdbdbd"
             colorBack = "#000000"
             sizeText = 20f
             styleText = 0
             paddingLeft = 10
             paddingTop = 0
             paddingRight = 10
             paddingButton = 0
         }
         return speaker
     }
 */

/*  private fun updateSpeaker14(speaker: Speaker): Speaker {
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


  private fun updateSpeaker5(speaker: Speaker): Speaker {
      //speaker.colorText = "#C70D3A"
      //speaker.colorBack = "#40BFC1"
      speaker.sizeText = 22f
      speaker.styleText = 0
      //speaker.paddingTop = 0
      // speaker.paddingButton = 0
      return speaker
  }*/

}