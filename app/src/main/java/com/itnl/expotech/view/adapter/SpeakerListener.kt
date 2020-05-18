package com.itnl.expotech.view.adapter

import com.itnl.expotech.model.Speaker

interface SpeakerListener {
    fun onSpeakerClicked(speaker: Speaker, position: Int)
}