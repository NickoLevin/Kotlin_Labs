package com.example.lab_3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var button: ImageButton
    private val adapter =   PostAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){


        binding.apply {
            rcView.layoutManager= LinearLayoutManager(this@MainActivity)
            rcView.adapter=adapter
            adapter.uploadData(addData())

        }


    }
    private fun addData(): List<Post> {
        val postList = ArrayList<Post>()
        postList.add(Post("Roman Kamushken","2 days ago",
            "Check out awesome updates for Android design kit for Figma. " +
                    "Now more screens and more categories.", "117 Replays", R.drawable.avatar1))

        postList.add(Post("Andrew Tate","a week ago",
            "Only sparkling water ", "1227 Replays", R.drawable.avatar3))

        postList.add(Post("Cheif Keef","5 years ago",
            "Love sosa " , "999 Replays", R.drawable.chmonjakot
        ))

        postList.add(Post("Hideo Kojimba","Yesterday",
            "Genius" , "9029 Replays", R.drawable.avatar3))

        postList.add(Post("Tatyana Emoti ","a few seconds ago",
            "Lorem Ipsum Ipsum Lorem?" , "999 Replays", R.drawable.avatar2))

        postList.add(Post("Hitori Akatsuma","5 years ago",
            "私はひとり" , "999 Replays", R.drawable.avatar1))

        postList.add(Post("Major Pain","10 years ago",
            "Chew-Chew" ,"0 Replays", R.drawable.chmonjakot))

        postList.add(Post("Love Sosa","5 years ago",
            "Cheif Keef " , "99 Replays", R.drawable.avatar2))

        postList.add(Post("Cheif Keef","5 years ago",
            "Love sosa " , "999 Replays", R.drawable.chmonjakot))

        postList.add(Post("Tina Turbina","18 minutes ago",
            "“into component container and with resizing constraints set????”", "117 Replays", R.drawable.avatar2))

        postList.add(Post("Tomek Kuwalskij","2 days ago",
            "“into component container and with resizing constraints set????”", "117 Replays", R.drawable.avatar3))
        return postList
    }
         fun clickListener(v:View){
             var mediator = Mediator()
             mediator.add(MyButton(findViewById(R.id.imageButton1),R.drawable.shoppinggray,R.drawable.shoppingblue,mediator))
             Log.d("ADD","Добавили кнопку")
             mediator.add(MyButton(findViewById(R.id.imageButton2),R.drawable.bookopenvariantgray,R.drawable.bookopenvariantblue,mediator))
             Log.d("ADD","Добавили кнопку")
             mediator.add(MyButton(findViewById(R.id.imageButton3),R.drawable.cartgray,R.drawable.cartblue,mediator))
             Log.d("ADD","Добавили кнопку")
             mediator.add(MyButton(findViewById(R.id.imageButton4),R.drawable.tagheartgray,R.drawable.tagheartblue,mediator))
             Log.d("ADD","Добавили кнопку")
             mediator.add(MyButton(findViewById(R.id.imageButton5),R.drawable.heart,R.drawable.blueheart,mediator))
             Log.d("ADD","Добавили кнопку")
                 mediator.requestAll(v)

    }

    private class Mediator{
        val buttonList = ArrayList<MyButton>()
        public fun add(myButton: MyButton){
            buttonList.add(myButton)
        }
        public fun requestAll(v: View){
            for(but: MyButton in buttonList){
                Log.d("myOWNFOR","Смотрим на " + but.offpic +" и " )
                if(but.v != v){
                    but.turnOff()
                } else {
                    but.turnOn()
                }
            }
        }
    }
    private class MyButton(v: View, offpic: Int, onpic: Int, mediator: Mediator) {
        var v : View = v
        var offpic : Int = offpic
        var onpic : Int = onpic
        var mediator: Mediator = mediator

        public fun turnOff(){
            (v as ImageButton).setImageResource(offpic)
        }
        public fun turnOn(){
            (v as ImageButton).setImageResource(onpic)
        }

    }
}


