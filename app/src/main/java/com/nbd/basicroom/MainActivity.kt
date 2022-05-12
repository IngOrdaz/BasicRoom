package com.nbd.basicroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.nbd.basicroom.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mainViewModel.saveUser(
//            User(
//                "asdf003",
//                "lkjh003",
//                1.84,
//                129.95,
//                "lakjd003@mail.com",
//                "contra12345"
//            )
//        )

        mainViewModel.getUsers()

        //fragment= viewLifecycleOwner en lugar de this
        mainViewModel.savedUsers.observe(this, { usersList ->
            if(!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("thesearetheusers",user.user_name)
                }
            }else {
                Log.d("thesearetheusers", "null or empty")
            }
        })
    }
}