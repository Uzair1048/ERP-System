package com.example.erpsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar

class SplashActivity : AppCompatActivity() {
  //  var img2: ImageView? = null
  //  var progress: ProgressBar? = null
   //     var animationUpToDown: Animation? = null
  //  var animationDownToUp: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
       // img2 = findViewById(R.id.img2)
       // progress = findViewById(R.id.progress)
      //  animationUpToDown = AnimationUtils.loadAnimation(this@SplashActivity,R.anim.uptodownanim)
       // animationDownToUp = AnimationUtils.loadAnimation(this@SplashActivity,R.anim.downtotopanim)

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        //Normal Handler is deprecated , so we have to change the code little bit

        // Handler().postDelayed({
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3000 is the delayed time in milliseconds.



    }
}