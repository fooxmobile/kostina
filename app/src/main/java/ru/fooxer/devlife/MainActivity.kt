package ru.fooxer.devlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import com.bumptech.glide.Glide
import ru.fooxer.devlife.ui.presentation.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var iv: ImageView
    private lateinit var title: TextView
    private lateinit var btnNext: Button
    private lateinit var btnPrev: Button
    private lateinit var btnRetry: Button

    private lateinit var errorGroup: Group
    private lateinit var contentGroup: Group

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        title = findViewById(R.id.tv_post_title)
        iv = findViewById(R.id.iv_gif)
        btnNext = findViewById(R.id.btn_next)
        btnPrev = findViewById(R.id.btn_prev)
        btnRetry = findViewById(R.id.btn_error_retry)

        errorGroup = findViewById(R.id.error_group)
        contentGroup = findViewById(R.id.content_group)

    }

    override fun onStart() {
        super.onStart()
        initViews()
    }

    private fun initViews() {
        viewModel.currentPost.observe(this, {
            Log.d("MAIN", "HERE")
            Glide.with(this)
                .load(it.gifUrl)
                .into(iv)

            title.text = it.description

            hideError()
        })

        viewModel.backButtonEnabled.observe(this, {
            btnPrev.isEnabled = it
        })

        viewModel.isErrorState.observe(this, {
            contentGroup.visibility = View.GONE
            errorGroup.visibility = View.VISIBLE
        })

        btnRetry.setOnClickListener {
            viewModel.retry()
        }

        btnNext.setOnClickListener {
            viewModel.loadNextPost()
        }

        btnPrev.setOnClickListener {
            viewModel.loadPreviousPost()
        }
    }

    private fun hideError() {
        contentGroup.visibility = View.VISIBLE
        errorGroup.visibility = View.GONE
    }
}