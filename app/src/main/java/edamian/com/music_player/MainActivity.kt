package edamian.com.music_player

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Button
import android.widget.EditText

import org.jetbrains.anko.alert

import java.io.File


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadPermissions()

        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnLoad = findViewById<Button>(R.id.btnLoad)
        val txtDirectory = findViewById<EditText>(R.id.txtDirectory)

        txtDirectory.setText(Environment.getExternalStorageDirectory().toString())

        btnPlay.setOnClickListener{
            alert ( "Playing music." ,"Hey!" ).show()
        }

        btnLoad.setOnClickListener{
            val path = txtDirectory.text.toString()

                val directory = File(path)
                val files = directory.listFiles().size
        }
    }

    fun loadPermissions(){
        if(ContextCompat.checkSelfPermission(this.applicationContext,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if(!ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1)
            }
        }
    }

}