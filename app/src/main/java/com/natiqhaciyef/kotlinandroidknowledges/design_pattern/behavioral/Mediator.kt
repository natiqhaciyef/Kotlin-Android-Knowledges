package com.natiqhaciyef.kotlinandroidknowledges.design_pattern.behavioral

interface ChatRoom {
    fun sendMessage(sender: User, message: String)
    fun addUser(user: User)
}

class TextChatRoom : ChatRoom {
    private val users = mutableListOf<User>()

    override fun sendMessage(sender: User, message: String) {
        users.forEach { user ->
            if (user != sender) {
                user.receiveMessage(sender, message)
            }
        }
    }

    override fun addUser(user: User) {
        users.add(user)
    }
}

data class User(private val name: String) {
    private lateinit var chatRoom: ChatRoom

    fun joinChatRoom(chatRoom: ChatRoom) {
        this.chatRoom = chatRoom
        chatRoom.addUser(this)
    }

    fun sendMessage(message: String) {
        chatRoom.sendMessage(this, message)
    }

    fun receiveMessage(sender: User, message: String) {
        println("$name received a message from $sender: $message")
    }
}


fun main() {
    val chatRoom = TextChatRoom()

    val john = User("John")
    val jane = User("Jane")
    val natiq = User("Natiq")

    john.joinChatRoom(chatRoom)
    jane.joinChatRoom(chatRoom)
    natiq.joinChatRoom(chatRoom)

    john.sendMessage("Hello, everyone!")
    jane.sendMessage("Hi, John!")
}
