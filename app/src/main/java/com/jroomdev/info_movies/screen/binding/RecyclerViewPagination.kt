package com.jroomdev.info_movies.screen.binding

import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewPagination(
  private val recyclerView: RecyclerView,
  private val isLoading: () -> Boolean,
  private val onLoad: (Int) -> Unit
) : RecyclerView.OnScrollListener() {

  var currentPage = 1

  init {
    recyclerView.addOnScrollListener(this)
    onLoad(currentPage)
  }

  override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
    super.onScrolled(recyclerView, dx, dy)

    val layoutManager = recyclerView.layoutManager
    layoutManager?.let {
      val totalItemCount = it.itemCount
      val visibleItemCount = it.childCount
      val firstVisibleItemPosition = when (layoutManager) {
        is LinearLayoutManager -> layoutManager.findLastVisibleItemPosition()
        is GridLayoutManager -> layoutManager.findLastVisibleItemPosition()
        else -> return
      }

      if (isLoading()) {
        Log.e("isLoading","isLoading")
        return
      }

      if ((firstVisibleItemPosition + 1) == totalItemCount){
        onLoad(++currentPage)
        //++currentPage
        Log.e("current","$currentPage")
      }
    }
  }

  fun resetCurrentPage() {
    this.currentPage = 1
  }
}