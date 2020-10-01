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
import com.lucas.desafioandroid.model.User
import com.lucas.desafioandroid.ui.adapter.PicPayAdapter
import com.lucas.desafioandroid.viewmodel.PicPayViewModel
import com.lucas.desafioandroid.viewmodel.state.PicPayState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var picPayRecyclerView: RecyclerView
    private val viewModel: PicPayViewModel by viewModel()

    private val clSuccess by lazy { findViewById<ConstraintLayout>(R.id.clSuccess) }
    private val llError by lazy { findViewById<LinearLayout>(R.id.llMessageError) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
        initViews()

    }

    private fun initViewModel() {
        viewModel.stateView.observe(this, Observer { event ->
            event?.let {
                when (event) {
                    is PicPayState.Success -> initListAdapter(event.getListPicPay)
                    is PicPayState.LoadingVisible -> loading()
                    is PicPayState.LoadingGone -> goneLoading()
                    is PicPayState.ListError -> showError()

                }
            }
        })
        viewModel.getList()
    }

    private fun initViews() {
        progressBar = findViewById(R.id.userListProgressBar)
        picPayRecyclerView = findViewById(R.id.recyclerView)

    }

    private fun initListAdapter(picPayList: List<User>) {
        picPayRecyclerView.layoutManager = LinearLayoutManager(this)
        picPayRecyclerView.adapter = PicPayAdapter(picPayList)
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
        llError.visibility = View.VISIBLE
        clSuccess.visibility = View.GONE

    }
}
