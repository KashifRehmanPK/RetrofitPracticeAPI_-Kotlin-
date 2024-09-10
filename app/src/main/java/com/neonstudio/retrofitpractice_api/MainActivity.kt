package com.neonstudio.retrofitpractice_api

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.neonstudio.retrofitpractice_api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //https://jsonplaceholder.typicode.com/todos/1


        binding.btnNewMeme.setOnClickListener{
            getData()
        }



    }

    private fun getData() {

        //progressbar
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage ("Please wait while data is fetch")
        progressDialog.show()


        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<ResponseModelClass?> {
            override fun onResponse(
                call: Call<ResponseModelClass?>,
                response: Response<ResponseModelClass?>
            ) {
                binding.memeTitle.text=response.body()?.title


                progressDialog.dismiss()
            }

            override fun onFailure(call: Call<ResponseModelClass?>, t: Throwable) {
                Toast.makeText(this@MainActivity,"${t.localizedMessage}",Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }
        })
    }


}
