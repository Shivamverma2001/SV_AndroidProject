package com.example.visitormanagmentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    lateinit var btn_Login: Button
    lateinit var fb:DatabaseReference
    lateinit var text1:TextView

    lateinit var edt_email: EditText
    lateinit var edt_password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        fb = FirebaseDatabase.getInstance().reference
        btn_Login = findViewById(R.id.Login_page_login_Button)
        edt_email = findViewById(R.id.LoginPage_email)
        text1=findViewById(R.id.textView)
        edt_password = findViewById(R.id.LoginPage_password)
        btn_Login.setOnClickListener{
            val email = edt_email.text.toString()
            val password = edt_password.text.toString()
            Login(email,password)
        }

    }
    private fun Login(email:String,password:String){
        var a=-1
        val getData=object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                var ab=StringBuilder()
                for(i in snapshot.children){
//                    var name=i.child("empName").getValue()
//                    var password=i.child("empPassword").getValue()
//                    ab.append("${i.key} ${name} ${password}")
                    if(email.dropLast(10).equals(i.key.toString())&&password.equals(i.child("empPassword").getValue().toString())){
                        a=1
                        break
                    }
                }
            }
        }
        if(a==1){
            Toast.makeText(this,"HI",Toast.LENGTH_LONG).show()
        }
        fb.addValueEventListener(getData)
        fb.addListenerForSingleValueEvent(getData)

    }



}