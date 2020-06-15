package com.chienducng.dependencyinjectionkodein.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.chienducng.dependencyinjectionkodein.R
import com.chienducng.dependencyinjectionkodein.data.model.Quote
import kotlinx.android.synthetic.main.activity_quotes.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class QuotesActivity : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein by closestKodein()
    private val viewModelFactory by instance<QuotesViewModelFactory>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUI()
    }

    private fun initializeUI() {
        // Use ViewModelProviders class to create / get already created QuotesViewModel
        // for this view (activity)
        val viewModel = ViewModelProvider(this, viewModelFactory)
            .get(QuotesViewModel::class.java)

        // Observing LiveData from the QuotesViewModel which in turn observes
        // LiveData from the repository, which observes LiveData from the DAO ☺
        viewModel.getQuote().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        // When button is clicked, instantiate a Quote and add it to DB through the ViewModel
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
