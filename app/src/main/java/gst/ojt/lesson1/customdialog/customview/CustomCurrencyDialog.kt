package gst.ojt.lesson1.customdialog.customview

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import gst.ojt.lesson1.customdialog.R
import kotlinx.android.synthetic.main.custom_dialog_layout.*

class CustomCurrencyDialog(
    private var activity: Activity,
    private var dataAdapter: DataAdapter,
    private var xCoordinate: Int,
    private var yCoordinate: Int,
    private var widthDialog: Int,
    private var heightDialog: Int
) : Dialog(activity) {
    init {
      //  requestWindowFeature(Window.FEATURE_NO_TITLE)
        setCanceledOnTouchOutside(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog_layout)

        val linearLayoutManager = LinearLayoutManager(activity)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = dataAdapter

        val window = this.window
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.setDimAmount(0f)
        val wlp = window?.attributes
   //     wlp?.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR
        wlp?.gravity = Gravity.TOP or Gravity.START
        wlp?.x = xCoordinate
        wlp?.y = yCoordinate - getHeightStatusBar(activity) + heightDialog
        wlp?.width = widthDialog
        window?.attributes = wlp

    }

    private fun getHeightStatusBar(activity: Activity): Int{
        val rectangle = Rect()
        val window = activity.window
        window?.decorView?.getWindowVisibleDisplayFrame(rectangle)
        val statusBarHeight: Int = rectangle.top
        val contentViewTop =
            window?.findViewById<View>(Window.ID_ANDROID_CONTENT)?.top
        val titleBarHeight = contentViewTop?.minus(statusBarHeight)
        Log.d(
            "statusbar height :: ",
            "$statusBarHeight"
        )
        return statusBarHeight
    }
}