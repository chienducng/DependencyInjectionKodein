package com.chienducng.dependencyinjectionkodein.data.repository

import androidx.lifecycle.LiveData
import com.chienducng.dependencyinjectionkodein.data.model.Quote

interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}