package com.freddydev.ciney.util.pagination

interface Paginator<Key, Item> {

  suspend fun loadNextItems()

  fun reset()
}