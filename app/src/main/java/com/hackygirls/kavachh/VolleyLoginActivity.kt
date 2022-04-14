package com.hackygirls.kavachh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.hackygirls.kavachh.databinding.ActivityVolleyLoginBinding
import kotlinx.android.synthetic.main.activity_volley_login.*
import kotlinx.android.synthetic.main.fragment_lender.*
import kotlinx.coroutines.*
import org.json.JSONException
import org.json.JSONObject


class VolleyLoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityVolleyLoginBinding
    private lateinit var navController : NavController
//    val username = binding.usernameInput.text.toString()
//    val pass = binding.passwordInput.text.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_volley_login)
        val username = binding.usernameInput.text.toString()
        val pass = binding.passwordInput.text.toString()
    binding.login.setOnClickListener {
        postData(username, pass)
        CoroutineScope(Dispatchers.IO).launch {
            for (i in 0..100) {
                delay(10)
                withContext(Dispatchers.Main) {
                    binding.progressBar.visibility = if (progressBar.visibility == View.VISIBLE){
                        View.INVISIBLE
                    } else{
                        View.VISIBLE
                    }
                    binding.progressBar.progress = i
                }
            }
            //Navigate to next fragment using nav contorller or with Intents for next Activity
            val i  = Intent(this@VolleyLoginActivity, MainActivity::class.java)
            startActivity(i)
            finish()

        }
//        val i  = Intent(this, MainActivity::class.java)
//        startActivity(i)
//        finish()
    }
    binding.signup.setOnClickListener {
        val i  = Intent(this, SignupActivity::class.java)
        startActivity(i)
        finish()
    }

    }
    private fun postData(username : String, password : String){
        val username = binding.usernameInput
        val pass = binding.passwordInput
        val url = "https://kavach-amex.herokuapp.com/KavachAuth/Login/Lender/"

        val queue = Volley.newRequestQueue(this@VolleyLoginActivity)

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        val request: StringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener { response ->
                // inside on response method we are
                // hiding our progress bar
                // and setting data to edit text as empty
                username.setText("")
                pass.setText("")

                // on below line we are displaying a success toast message.
                Toast.makeText(this@VolleyLoginActivity, "Data added to API", Toast.LENGTH_SHORT).show()
                try {
                    // on below line we are passing our response
                    // to json object to extract data from it.
                    val respObj = JSONObject(response)

                    // below are the strings which we
                    // extract from our json object.
                    val name = respObj.getString("name")
                    val job = respObj.getString("job")

                    // on below line we are setting this string s to our text view.
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, Response.ErrorListener { error -> // method to handle errors.
//                Toast.makeText(
//                    this@VolleyLoginActivity,
//                    "Fail to get response = $error",
//                    Toast.LENGTH_SHORT
//                ).show()
            }) {
            override fun getParams(): Map<String, String>? {
                // below line we are creating a map for
                // storing our values in key and value pair.
                val params: MutableMap<String, String> = HashMap()

                // on below line we are passing our key
                // and value pair to our parameters.
                params["username"] = username.text.toString()
                params["password"] = pass.text.toString()

                // at last we are
                // returning our params.
                return params
            }


        }
        // below line is to make
        // a json object request.
        // below line is to make
        // a json object request.
        queue.add(request)

    }
}