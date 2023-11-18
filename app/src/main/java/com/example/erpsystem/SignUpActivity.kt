package com.example.erpsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.erpsystem.HomeActivity
import com.example.erpsystem.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference("User")
        binding.btsignup.setOnClickListener {


            val Email = binding.etmail.text.toString()
            val Password = binding.etpass.text.toString()
            val fullname = binding.etfullname.text.toString()
            val fathername = binding.etfather.text.toString()
            val phonenumber = binding.etphonenum.text.toString()
            val CNIC = binding.etcnic.text.toString()
            val DateofBirth = binding.etdateofbirth.text.toString()
            val Address = binding.etaddress.text.toString()


            if (Email.isNotEmpty() && Password.isNotEmpty() && fullname.isNotEmpty() && fathername.isNotEmpty() && phonenumber.isNotEmpty() &&
                CNIC.isNotEmpty() && DateofBirth.isNotEmpty() && Address.isNotEmpty()
            ) {

                firebaseAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener {
                    if (it.isSuccessful) {

                        val user =
                            User(Email, Password, fullname, fathername, phonenumber, CNIC, DateofBirth, Address)
                        database.child(fullname).setValue(user).addOnSuccessListener {

                            binding.etmail.text.clear()
                            binding.etpass.text.clear()
                            binding.etfullname.text.clear()
                            binding.etfather.text.clear()
                            binding.etphonenum.text.clear()
                            binding.etcnic.text.clear()
                            binding.etdateofbirth.text.clear()
                            binding.etaddress.text.clear()

                            Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()

                        }.addOnFailureListener {
                            Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()
                        }


                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)


                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }

                }

            } else {
                Toast.makeText(this, "Empty fields are not allowed!!", Toast.LENGTH_SHORT).show()
            }

        }
    }

}