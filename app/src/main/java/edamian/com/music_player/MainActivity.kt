package edamian.com.music_player

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnTouchMe = findViewById<Button>(R.id.btnTouchMe)

        btnTouchMe.setOnClickListener{
            Toast.makeText(this.applicationContext,"Hey!",Toast.LENGTH_SHORT).show()
        }
    }

}