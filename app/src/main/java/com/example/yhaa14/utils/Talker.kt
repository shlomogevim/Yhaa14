package com.example.yhaa14.utils

import java.io.Serializable

class Talker(
    var whoSpeake: String = "man",
    var taking: String = "tadam",
    var styleNum: Int = 0,
    var animNum: Int = 0,
    var dur: Long = 1000
) : Serializable