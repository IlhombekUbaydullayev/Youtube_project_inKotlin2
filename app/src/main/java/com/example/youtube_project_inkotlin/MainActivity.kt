package com.example.youtube_project_inkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messenger_facebook.Chat
import com.example.messenger_facebook.model.Message
import com.example.messenger_facebook.model.Room
import com.example.youtube_project_inkotlin.adapter.FeedAdapter
import com.example.youtube_project_inkotlin.adapter.FilterAdapter
import com.example.youtube_project_inkotlin.model.Filter

class MainActivity : AppCompatActivity() {

    lateinit var recyclerFeed: RecyclerView
    lateinit var recyclerFilter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        recyclerFilter = findViewById(R.id.recyclerFilter)
        recyclerFilter.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerFeed = findViewById(R.id.recyclerFeed)
        recyclerFeed.layoutManager = GridLayoutManager(this,1)
        refreshFilterAdapter(getAllFilters())
        refreshFeedAdapter(getAllFeeds())
    }

    private fun getAllFilters(): ArrayList<Filter> {
        val chats : ArrayList<Filter> = ArrayList()
        chats.add(Filter("Ilhombek",true))
        chats.add(Filter("Ilhombek"))
        chats.add(Filter("Abdumajid"))
        chats.add(Filter("Bek"))
        chats.add(Filter("Bek"))
        chats.add(Filter("Bek"))
        chats.add(Filter("Bek"))

        return chats
    }

    private fun getAllFeeds(): ArrayList<Chat> {

        val stories: ArrayList<Room> = ArrayList<Room>()
        val chats: ArrayList<Chat> = ArrayList()

        chats.add(Chat(Message(R.drawable.product8,R.drawable.img26,"Ilhombek"),1))
        chats.add(Chat(Message(R.drawable.img28,R.drawable.img28,"Maqsit"),1))

        chats.add(Chat(Message(0,0,""),3))
        stories.add(Room(R.drawable.img24,"Ilhombek","Shor videos","All coments","Best"))
        stories.add(Room(R.drawable.img25,"Laziz Ubaydullayev","Shor videos","All coments","Best"))
        stories.add(Room(R.drawable.img26,"Amir Ubaydullayev","Shor videos","All coments","Best"))
        stories.add(Room(R.drawable.img24,"Umid Ubaydullayev","Shor videos","All coments","Best"))
        stories.add(Room(R.drawable.img26,"Adham Ubaydullayev","Shor videos","All coments","Best"))
        stories.add(Room(R.drawable.img29,"Azim Ubaydullayev","Shor videos","All coments","Best"))
        stories.add(Room(R.drawable.img28,"Kamron Ubaydullayev","Shor videos","All coments","Best"))

        chats.add(Chat(stories))

        chats.add(Chat(Message(R.drawable.img24,R.drawable.img25,"Jamol"),1))
        chats.add(Chat(Message(R.drawable.img29,R.drawable.img24,"Karim"),1))
        chats.add(Chat(Message(R.drawable.img26,R.drawable.img27,"Leyla"),1))
        chats.add(Chat(Message(R.drawable.img29,R.drawable.img24,"Amanda"),1))
        chats.add(Chat(Message(R.drawable.img24,R.drawable.img29,"Alex"),1))
        chats.add(Chat(Message(R.drawable.img27,R.drawable.img26,"Bahodir"),1))
        chats.add(Chat(Message(R.drawable.img25,R.drawable.img25,"Olim"),1))
        chats.add(Chat(Message(R.drawable.img24,R.drawable.img26,"Zayniddin"),1))
        chats.add(Chat(Message(R.drawable.img29,R.drawable.img28,"Javohir"),1))
        chats.add(Chat(Message(R.drawable.img24,R.drawable.img26,"Umit"),1))
        chats.add(Chat(Message(R.drawable.img27,R.drawable.img29,"Zaynab"),1))
        chats.add(Chat(Message(R.drawable.img28,R.drawable.img26,"Sherali"),1))

        return chats
    }

    private fun refreshFeedAdapter(chats: ArrayList<Chat>) {
        val adapter = FeedAdapter(this,chats)
        recyclerFeed.adapter = adapter
    }

    private fun refreshFilterAdapter(chats: ArrayList<Filter>) {
        val adapter = FilterAdapter(this,chats)
        recyclerFilter.adapter = adapter
    }
}