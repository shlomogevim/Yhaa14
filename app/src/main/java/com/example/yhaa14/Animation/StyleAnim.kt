package com.example.yhaa14.Animation

import com.example.yhaa14.utils.Speaker

object StyleAnim {

    fun updateNewStyle(counter: Int, speaker: Speaker): Speaker {
        var speaker1 = Speaker()

        if (speaker.whoSpeake == "god") {
            speaker1 = updateGodStyle(counter, speaker)
        } else {
            speaker1 = updateManStyle(counter, speaker)

        }


        return speaker1
    }


    private fun updateGodStyle(counter: Int, speaker: Speaker): Speaker {
        when (counter) {

            12 -> makeStyle(speaker, "none", "#6ff9ff", 34f, 1, 10, 5, 10, 0)
            14 -> makeStyle(speaker, "none", "#6ff9ff", 22f, 1, 10, 5, 10, 0)
        }



        return speaker
    }


    private fun updateManStyle(counter: Int, speaker: Speaker): Speaker {
        when (counter) {

            13 -> makeStyle(speaker, "#ffffff", "#000000", 24f, 1, 10, 0, 10, 0)
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


    fun updateSpeaker1(speaker: Speaker): Speaker {
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

    fun updateSpeaker2(speaker: Speaker): Speaker {
        speaker.colorText = "#44000D"
        speaker.sizeText = 50f
        speaker.styleText = 1
        speaker.paddingTop = 20
        speaker.paddingButton = 20
        return speaker
    }

    fun updateSpeaker4(speaker: Speaker): Speaker {
        speaker.colorText = "#f9a825"
        speaker.sizeText = 140f
        speaker.styleText = 1
        speaker.paddingTop = 80
        return speaker
    }

    fun updateSpeaker5(speaker: Speaker): Speaker {
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
    }

    fun updateSpeaker7(speaker: Speaker): Speaker {
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
    }


    fun updateSpeaker8(speaker: Speaker): Speaker {
        speaker.colorText = "#44000D"
        speaker.sizeText = 40f
        speaker.styleText = 1
        speaker.paddingTop = 20
        speaker.paddingButton = 20
        return speaker
    }

    fun updateSpeaker10(speaker: Speaker): Speaker {
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
    }

    fun updateSpeaker11(speaker: Speaker): Speaker {
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
    }

    fun updateSpeaker12(speaker: Speaker): Speaker {
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
    }

    fun updateSpeaker13(speaker: Speaker): Speaker {
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