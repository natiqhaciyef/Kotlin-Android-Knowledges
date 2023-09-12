package com.natiqhaciyef.kotlinandroidknowledges.algorithms.custom_collections

class CustomMap <K, V>{
    private val list: MutableList<Pair<K,V>> = mutableListOf()

    fun insert(pair: Pair<K, V>){
        list.add(pair)
    }

    fun remove(key: K){
        for (pair in list){
            if (pair.first == key) {
                list.remove(pair)
                return
            }
        }
    }

    fun get(key: K): V? {
        var type: Pair<K, V>? = null
        for (pair in list){
            if (pair.first == key){
                type = pair
            }
        }
        return type?.second
    }

    private fun hash(key: K): Int{
        return key.hashCode() % 101
    }
}