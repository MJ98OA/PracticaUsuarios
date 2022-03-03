package com.example.practicausuarios

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicausuarios.databinding.ActivityMainBinding
import com.example.practicausuarios.databinding.UsuariosBinding
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: UserAdapter


    companion object {
        const val TAG_TEXT = "TAG_TEXT"

        fun launch(context: Context, text: String) {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(TAG_TEXT, text)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val initialData=intent.getStringExtra(TAG_TEXT)


        val client = OkHttpClient()

        val request = Request.Builder()
        request.url("https://randomuser.me/api/?results=5")


        val call = client.newCall(request.build())
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e.toString())

            }

            override fun onResponse(call: Call, response: Response) {
                println(response.toString())
                response.body?.let { responseBody ->
                    val body = responseBody.string()
                    println(body)

                    val gson = GsonBuilder().create()

                    val planet = gson.fromJson(body, UsuariosApi::class.java)

                    CoroutineScope(Dispatchers.Main).launch {
                        Toast.makeText(this@MainActivity, planet.results.toString(), Toast.LENGTH_SHORT).show()
                    }

                }
            }
        })


    }

    private fun recicleview(users: UsuariosApi){
        binding.recyclerview.layoutManager=LinearLayoutManager(this)
        adapter = UserAdapter(users.results)
        binding.recyclerview.adapter = adapter

    }


}






