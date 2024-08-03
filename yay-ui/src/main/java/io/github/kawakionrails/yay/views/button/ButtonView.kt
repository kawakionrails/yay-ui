package io.github.kawakionrails.yay.views.button

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import androidx.viewbinding.ViewBinding
import io.github.kawakionrails.yay.ui.R
import io.github.kawakionrails.yay.ui.databinding.ViewButtonBinding

class ButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewButtonBinding =
        ViewButtonBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        attrs?.let {
            val styledAttributes = context.obtainStyledAttributes(it, R.styleable.ButtonView)
            val textResId = styledAttributes.getString(R.styleable.ButtonView_text) ?: ""
            val callbackResId = styledAttributes.getString(R.styleable.ButtonView_callback) ?: ""
            setText(textResId)
            setCallback(callbackResId)
            styledAttributes.recycle()
        }
    }

    fun setText(textResId: String) {
        binding.text.text = textResId
    }

    fun setCallback(callbackResId: String) {
        if (callbackResId.isEmpty()) {
            binding.callback.visibility = View.GONE
            return
        }
        binding.callback.text = callbackResId
    }

}