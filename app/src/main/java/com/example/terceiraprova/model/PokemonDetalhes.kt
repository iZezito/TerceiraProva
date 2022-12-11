package com.example.terceiraprova.model

import com.google.gson.annotations.SerializedName

data class PokemonDetalhes(
    @SerializedName("weight") var weight: String,
    @SerializedName("height") var height: String,
    @SerializedName("name") var name: String,
    @SerializedName("sprites") var imagemUrl: String,
) {

}