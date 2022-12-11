package com.example.terceiraprova.retrofit


import com.example.terceiraprova.model.Pokemon
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    @GET("pokemon?limit=100000&offset=0")
    fun getPokemons() : Call<JsonObject>
}