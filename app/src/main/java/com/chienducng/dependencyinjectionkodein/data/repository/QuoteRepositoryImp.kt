package com.chienducng.dependencyinjectionkodein.data.repository

import androidx.lifecycle.LiveData
import com.chienducng.dependencyinjectionkodein.data.db.QuoteDao
import com.chienducng.dependencyinjectionkodein.data.model.Quote

class QuoteRepositoryImp (private val quoteDao: QuoteDao) : QuoteRepository{
    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes(): LiveData<List<Quote>> = quoteDao.getQuotes()

}