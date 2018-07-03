package com.lalitdhameliya.progressbutton

import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.ViewFlipper


/**
 * Created by Lalit on 28-Jun-18.
 */
class ProgressButton : FrameLayout {
    private var mButtonText: String? = null
    private var mButtonTextColor: Int = 0
    private var mProgressTint: Int = 0
    private var mViewFlipper: ViewFlipper? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val a = context.theme.obtainStyledAttributes(attrs,
                R.styleable.ProgressButton, 0, 0)
        mButtonText = a.getString(R.styleable.ProgressButton_text)
        mButtonTextColor = a.getColor(R.styleable.ProgressButton_textColor, 0)
        mProgressTint = a.getInteger(R.styleable.ProgressButton_progressTint, 0)
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        val view = inflate(context, R.layout.progress_button, this)
        mViewFlipper = view.findViewById(R.id.layout_progress_button_view_flipper)
        val textView = view.findViewById<TextView>(R.id.layout_progress_button_tv_text)
        val progressBar = view.findViewById<ProgressBar>(R.id.layout_progress_button_progress_bar)

        if (mButtonText != null) textView.text = mButtonText
        if (mButtonTextColor != 0) textView.setTextColor(mButtonTextColor)

        if (mProgressTint != 0)
            progressBar.indeterminateDrawable.setColorFilter(mProgressTint, PorterDuff.Mode.SRC_ATOP)
    }

    /**
     * This method is used to show/hide the progressbar.
     *
     * @param shouldShowProgress show progressbar if true/hide progressbar if false.
     */
    fun showProgress(shouldShowProgress: Boolean) {
        if (shouldShowProgress) {
            mViewFlipper?.displayedChild = 1
            mViewFlipper?.isClickable = false
        } else {
            mViewFlipper?.displayedChild = 0
            mViewFlipper?.isClickable = true
        }
    }
}