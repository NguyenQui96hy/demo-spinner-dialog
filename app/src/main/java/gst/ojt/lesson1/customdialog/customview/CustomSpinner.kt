package gst.ojt.lesson1.customdialog.customview

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import gst.ojt.lesson1.customdialog.R
import kotlinx.android.synthetic.main.activity_main.*


@SuppressLint("AppCompatCustomView")
class CustomSpinner @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), ISpinner {

    private var customDialog: CustomCurrencyDialog? = null
    private var tvSpinner: TextView? = null

    private var dataAdapter: DataAdapter? = null

    private var xC: Int = 0
    private var yC: Int = 0
    private var widthDialog: Int = 0
    private var heightDialog: Int = 0
    private var isDisableSpinner : Boolean = false


    init {
        val view: View = View.inflate(context, R.layout.custom_spinner, this)
        initView(view)
        handleViewDialog()

    }

    private fun initView(view: View) {
        tvSpinner = view.findViewById(R.id.tv_spinner)
        tvSpinner?.setOnClickListener {
            openSpinner()
        }
    }

    private fun handleViewDialog() {
        tvSpinner?.post {
            widthDialog = tvSpinner!!.width
            heightDialog = tvSpinner!!.height
            Log.d("withSpiner", widthDialog.toString())
            val location = IntArray(2)
            tvSpinner?.getLocationInWindow(location)
            xC = location[0]
            yC = location[1]
            Log.d("coorView:", "$xC && $yC")
        }


    }

    /**
     * This function handle open spinner
     */
    override fun openSpinner() {
        if (!isDisableSpinner)
            customDialog =
                CustomCurrencyDialog(
                    context as Activity,
                    dataAdapter!!,
                    xC,
                    yC,
                    widthDialog,
                    heightDialog
                )
        customDialog?.show()
    }

    /**
     * This function using set adapter for spinner
     */
    override fun setAdapter(dataAdapter: DataAdapter) {
        this.dataAdapter = dataAdapter
        dataAdapter.setOnItemSelect(object : DataAdapter.RecyclerViewItemClickListener {
            override fun clickOnItem(data: String) {
                tvSpinner?.text = data
                closeSpinner()
            }
        })
    }

    override fun disableSpinner(isDisable: Boolean) {
        this.isDisableSpinner = isDisable
    }

    /**
     * this function handle close spinner
     */
    override fun closeSpinner() {
        customDialog?.cancel()
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
    }
}