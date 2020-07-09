package gst.ojt.lesson1.customdialog.customview

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gst.ojt.lesson1.customdialog.R
import kotlinx.android.synthetic.main.custom_dialog_layout.*

/**
 * This class is defined as a parent class for all fragments which will be displayed as a DialogFragment.
 *
 * It only shows the content provided by its sub-class.
 * It provides a function which is used to retrieve id of screen.
 * onProvideScreenId() function provides the id of screen which will be displayed.
 */
class BaseDialogFragment(private var activity: Activity, private var adapter: RecyclerView.Adapter<*>) : DialogFragment() {

    private var recyclerView: RecyclerView? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recyclerView = recycler_view
        mLayoutManager = LinearLayoutManager(activity)
        recyclerView?.layoutManager = mLayoutManager
        recyclerView?.adapter = adapter
        return inflater.inflate(R.layout.custom_dialog_layout, container, false)
    }
}
