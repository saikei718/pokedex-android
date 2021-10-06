package com.example.pokedex.scene.pokemon_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.infra.pokeapi.PokeApi
import com.example.pokedex.infra.pokeapi.entity.PokemonListElement
import kotlinx.coroutines.launch

class PokemonListViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val pokemonList: LiveData<List<PokemonListElement>>
        get() = _pokemonList
    private val _pokemonList = MutableLiveData<List<PokemonListElement>>()

    fun onViewCreated() {
        viewModelScope.launch {
            PokeApi.retrofitService.getPokemon().body()?.let {
                _pokemonList.postValue(it.results)
            }
        }
    }
}