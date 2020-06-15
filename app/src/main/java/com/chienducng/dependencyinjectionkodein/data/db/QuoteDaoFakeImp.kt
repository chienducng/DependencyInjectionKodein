package com.chienducng.dependencyinjectionkodein.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chienducng.dependencyinjectionkodein.data.model.Quote

class QuoteDaoFakeImp : QuoteDao{
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    override fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    override fun getQuotes(): LiveData<List<Quote>> = quotes
}