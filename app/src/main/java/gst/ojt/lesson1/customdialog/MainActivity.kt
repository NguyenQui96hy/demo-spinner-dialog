package gst.ojt.lesson1.customdialog

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import gst.ojt.lesson1.customdialog.customview.CustomCurrencyDialog
import gst.ojt.lesson1.customdialog.customview.DataAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = arrayOf(
            "Apple ",
            "Banana",
            "Orange"
        )
      val  dataAdapter = DataAdapter(items, object : DataAdapter.RecyclerViewItemClickListener{
            override fun clickOnItem(data: String) {
                Log.d("#onAttachedToWindow", "onAttachedToWindow")
            }
        })
        customSpinner?.setAdapter(dataAdapter)
        customSpinner?.disableSpinner(false)


    }

    override fun onAttachedToWindow() {
        Log.d("#onAttachedToWindow", "onAttachedToWindow")
        super.onAttachedToWindow()
//        window.setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
    }


}
