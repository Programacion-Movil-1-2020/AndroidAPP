package com.itnl.expotech.view.adapter

import com.itnl.expotech.model.Conference

interface ScheduleListener {
    fun onConferenceClicked(conference: Conference, position: Int)
}