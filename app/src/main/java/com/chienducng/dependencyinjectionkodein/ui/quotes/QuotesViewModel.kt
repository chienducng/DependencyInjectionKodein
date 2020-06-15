package com.chienducng.dependencyinjectionkodein.ui.quotes

import androidx.lifecycle.ViewModel
import com.chienducng.dependencyinjectionkodein.data.model.Quote
import com.chienducng.dependencyinjectionkodein.data.repository.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

    fun getQuote() = quoteRepository.getQuotes()
}