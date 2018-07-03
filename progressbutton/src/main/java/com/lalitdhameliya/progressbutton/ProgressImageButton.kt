package com.lalitdhameliya.progressbutton

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.ViewFlipper

/**
 * Created by Lalit on 05-Jun-17.
 * This class contains a image view and progressbar. These views can be switch between button and progress
 * layout.
 *
 */

class ProgressImageButton : RelativeLayout {

    private var mImageView: AppCompatImageView? = null
    private var mProgressBar: ProgressBar? = null

    /**
     * This are the attributes.
     */
    private var mProgressTint: Int = 0
    private var mButtonSrc: Drawable? = null
    private var mButtonSrcTint: Int = 0

    private var mViewFlipper: ViewFlipper? = null

    /**
     * This method is used to initialize the layout for progress button.
     *
     * @param context instance caller.
     */
    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {

        val a = context.theme.obtainStyledAttributes(attrs,
                R.styleable.ProgressImageButton, 0, 0)
        mButtonSrc = a.getDrawable(R.styleable.ProgressImageButton_src)
        mButtonSrcTint = a.getColor(R.styleable.ProgressImageButton_srcTint, 0)
        mProgressTint = a.getInteger(R.styleable.ProgressImageButton_progressTint, android.R.color.white)

        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context)
    }

    /**
     * It will initialize the progress button.
     *
     * @param context instance of the caller.
     */
    private fun init(context: Context) {
        val view = View.inflate(context, R.layout.image_progress_button, this)
        mViewFlipper = view.findViewById(R.id.layout_progress_button_view_flipper) as ViewFlipper
        mImageView = view.findViewById(R.id.layout_image_progress_image_view) as AppCompatImageView
        mProgressBar = view.findViewById(R.id.layout_image_progress_button_progress_bar) as ProgressBar

        setupAttributes()
    }

    /**
     * This method is used to setup view based on attributes.
     */
    private fun setupAttributes() {
        if (mButtonSrc != null) mImageView!!.setImageDrawable(mButtonSrc)
        if (mButtonSrcTint != 0)
            mImageView!!.drawable.setColorFilter(mButtonSrcTint, PorterDuff.Mode.SRC_ATOP)
        if (mProgressTint != 0)
            mProgressBar!!.indeterminateDrawable.setColorFilter(mProgressTint, PorterDuff.Mode.SRC_ATOP)
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
