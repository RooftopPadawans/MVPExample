package com.flknlabs.mvpexample.View

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.flknlabs.mvpexample.Presenter.PersonContract
import com.flknlabs.mvpexample.Presenter.PersonPresenter
import com.flknlabs.mvpexample.R


class MainActivity : AppCompatActivity(), PersonContract.View, View.OnClickListener {

    private val mPresenter by lazy {
        PersonPresenter(this)
    }

    private var mMessageView: TextView? = null
    private var mFirstNameView: EditText? = null
    private var mLastNameView: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        mMessageView = findViewById<TextView>(R.id.message)
        mFirstNameView = findViewById<EditText>(R.id.firstName)
        mLastNameView = findViewById<EditText>(R.id.lastName)

        findViewById<Button>(R.id.update).setOnClickListener(this)
        findViewById<Button>(R.id.showMessage).setOnClickListener(this)
    }

    override fun showMessage(message: String) {
        mMessageView?.text = message
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.update -> {
                mPresenter.saveName(
                    mFirstNameView?.text.toString(),
                    mLastNameView?.text.toString()
                )
            }
            R.id.showMessage -> {
                mPresenter.loadMessage()
            }
        }
    }
}