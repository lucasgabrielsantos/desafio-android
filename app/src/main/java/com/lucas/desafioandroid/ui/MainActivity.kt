package com.lucas.desafioandroid.ui

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucas.desafioandroid.R
import com.lucas.desafioandroid.model.Users
import com.lucas.desafioandroid.ui.adapter.PicPayAdapter
import com.lucas.desafioandroid.viewmodel.PicPayViewModel
import com.lucas.desafioandroid.viewmodel.event.PicPayEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var picPayRecyclerView: RecyclerView
    private val viewModel: PicPayViewModel by viewModel()

    private val clSuccess by lazy { findViewById<ConstraintLayout>(R.id.cl_Success) }
    private val llError by lazy { findViewById<LinearLayout>(R.id.ll_messageError) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        initViews()

    }

    private fun initViewModel() {
        viewModel.eventView.observe(this, Observer { event ->
            event?.let {
                when (event) {
                    is PicPayEvent.Success -> initListAdapter(event.getListPicPay)
                    is PicPayEvent.LoadingVisible -> loading()
                    is PicPayEvent.LoadingGone -> goneLoading()
                    is PicPayEvent.ListError -> showError()

                }
            }
        })
        viewModel.getList()
    }

    private fun initViews() {
        progressBar = findViewById(R.id.user_list_progress_bar)
        picPayRecyclerView = findViewById(R.id.recyclerView)

    }

    private fun initListAdapter(picPayList: List<Users>) {
        picPayRecyclerView.layoutManager = LinearLayoutManager(this)
        picPayRecyclerView.adapter =
            PicPayAdapter(
                picPayList
            )
        picPayRecyclerView.visibility = View.VISIBLE
        clSuccess.visibility = View.VISIBLE
        llError.visibility = View.GONE
    }

    private fun loading() {
        progressBar.visibility = View.VISIBLE
    }

    private fun goneLoading() {
        progressBar.visibility = View.GONE
    }

    private fun showError() {
        progressBar.visibility = View.GONE
        llError.visibility = View.VISIBLE
        clSuccess.visibility = View.GONE

    }
}
