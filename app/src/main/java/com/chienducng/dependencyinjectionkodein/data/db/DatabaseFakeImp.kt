package com.chienducng.dependencyinjectionkodein.data.db

class DatabaseFakeImp : Database {

    override val quoteDao: QuoteDao = QuoteDaoFakeImp()
}