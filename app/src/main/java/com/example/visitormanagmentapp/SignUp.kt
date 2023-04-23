package com.example.visitormanagmentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    lateinit var btn_Create_Account: Button
    lateinit var btn_Confirm_Account:EditText
    lateinit var name: EditText
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var fb:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        fb = FirebaseDatabase.getInstance().reference

        btn_Create_Account = findViewById(R.id.Signup_Page_CreateAccount)
        name = findViewById(R.id.SignUp_Page_name)
        email = findViewById(R.id.SignUp_Page_email)
        password = findViewById(R.id.SignUp_Page_password)
        btn_Confirm_Account=findViewById(R.id.SignUp_Page_Confirm_password)



        btn_Create_Account.setOnClickListener{
                val ename = name.text.toString()
                val eemail = email.text.toString()
                val epassword = password.text.toString()

                SignUp(ename, eemail, epassword)
        }

    }



    private fun SignUp(ename:String,eemail:String,epassword:String){
        val empName = ename
        val empMail = eemail
        val empPassword = epassword
        if(empName.isEmpty()||empMail.isEmpty()||empPassword.isEmpty()||btn_Confirm_Account.text.toString()!=password.text.toString()) {
            if (empName.isEmpty()) {
                name.error = "Please Enter Your Name"
            }
            if (empMail.isEmpty()) {
                email.error = "Please Enter Your Mail"
            }
            if (empPassword.isEmpty()) {
                password.error = "Please Enter Your Password"
            }
            if (btn_Confirm_Account.text.toString() != password.text.toString()) {
                btn_Confirm_Account.error = "Please Enter Right Password"
            }
        }else {
            val employee = VistorModel(empName, empPassword)
            fb.child(empMail.toString().dropLast(10)).setValue(employee)
                .addOnCompleteListener {
                    Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()

                    name.text.clear()
                    email.text.clear()
                    password.text.clear()
                    btn_Confirm_Account.text.clear()
                    val i=Intent(this,Login::class.java)
                    startActivity(i)

                }.addOnFailureListener { err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
                }
        }
    }
}