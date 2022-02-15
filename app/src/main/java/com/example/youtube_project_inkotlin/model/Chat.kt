package com.example.messenger_facebook

import com.example.messenger_facebook.model.Message
import com.example.messenger_facebook.model.Room


class Chat {
    var message: Message? = null
    var rooms: ArrayList<Room> = ArrayList()
    var position: Int = 0

    constructor(message: Message,position:Int) {
        this.message = message
        this.position = position
    }

    constructor(rooms:ArrayList<Room>) {
        this.rooms = rooms
    }
}