package com.example.terceiraprova.fragments.home

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.terceiraprova.model.Pokemon
import com.example.terceiraprova.retrofit.Endpoint
import com.example.terceiraprova.retrofit.NetworkUtils
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {

    val listPokemons = MutableLiveData<List<Pokemon>>()

    init {
        listPokemons.value = listOf()
    }

    fun getData(){
        val listPokemon = mutableListOf<Pokemon>()
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://pokeapi.co/api/v2/")

        val endpoint = retrofitClient.create(Endpoint::class.java)

        val callback = endpoint.getPokemons()

        callback.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                response.body()?.let {

                    for (i in 0..it.getAsJsonArray("results").size()-1){
                        val pokemon = Pokemon(
                            it.getAsJsonArray("results").get(i).asJsonObject.get("name").asString,
                            it.getAsJsonArray("results").get(i).asJsonObject.get("url").asString
                        )
                        listPokemon.add(pokemon)
                    }
                    Log.i("teste", listPokemon.toString())
                    listPokemons.postValue(listPokemon)
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.i("ERRO", "Erro ao buscar os dados")
            }

        })




    }

}
