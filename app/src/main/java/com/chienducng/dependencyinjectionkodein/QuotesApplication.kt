package com.chienducng.dependencyinjectionkodein

import android.app.Application
import com.chienducng.dependencyinjectionkodein.data.db.Database
import com.chienducng.dependencyinjectionkodein.data.db.DatabaseFakeImp
import com.chienducng.dependencyinjectionkodein.data.db.QuoteDao
import com.chienducng.dependencyinjectionkodein.data.repository.QuoteRepository
import com.chienducng.dependencyinjectionkodein.data.repository.QuoteRepositoryImp
import com.chienducng.dependencyinjectionkodein.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseFakeImp() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImp(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }
    }
}