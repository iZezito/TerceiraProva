package com.example.terceiraprova.fragments.detalhes

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.terceiraprova.model.Pokemon
import com.example.terceiraprova.model.PokemonDetalhes
import com.example.terceiraprova.retrofit.Endpoint
import com.example.terceiraprova.retrofit.NetworkUtils
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalhesViewModel : ViewModel() {
    val pokemon = MutableLiveData<PokemonDetalhes>()

    init {
        pokemon.value = PokemonDetalhes("", "", "", "")
    }

    fun getPokemon(url: String) {
        val urlFinal = url.replace("https://pokeapi.co/api/v2/", "")
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://pokeapi.co/api/v2/")

        val endpoint = retrofitClient.create(Endpoint::class.java)

        val callback = endpoint.getPokemonDetalhes(urlFinal)

        callback.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    pokemon.postValue(PokemonDetalhes(
                        response.body()?.entrySet()?.find{it.key == "weight"}?.value?.asString ?: "",
                        response.body()?.entrySet()?.find{it.key == "height"}?.value?.asString ?: "",
                        response.body()?.entrySet()?.find{it.key == "name"}?.value?.asString ?: "",
                        response.body()?.entrySet()?.find{it.key == "sprites"}?.value?.asJsonObject?.entrySet()?.find{it.key == "front_default"}?.value?.asString ?: ""

                    ))
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.i("ERRO", "Erro ao buscar os dados")
            }

        })

    }

}