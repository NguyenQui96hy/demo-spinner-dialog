package gst.ojt.lesson1.customdialog

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import android.view.ViewGroup
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
import android.view.WindowManager.LayoutParams.TYPE_SYSTEM_ERROR
import android.widget.FrameLayout

/**
 * This class is used to handle block/unblock press KEY HOME.
 */

class HomeKeyLocker {
    private var mOverlayDialog: OverlayDialog? = null

    /**
     * @param activity is Activity of alert dialog
     * This function is used to handle block KEY HOME using show alert dialog TRANSPARENT to overlay.
     */
    fun lock(activity: Activity) {
        if (mOverlayDialog == null) {
            mOverlayDialog = OverlayDialog(activity)
            mOverlayDialog?.show()
        }
    }

    /**
     * This function is used to dismiss alert dialog TRANSPARENT overlay.
     */
    fun unlock() {
        if (mOverlayDialog != null) {
            mOverlayDialog?.dismiss()
            mOverlayDialog = null
        }
    }

    private class OverlayDialog(activity: Activity) : AlertDialog(activity, R.style.OverlayDialog) {

        init {
            val layoutParams = window?.attributes
            // Overlay windows are displayed above activity
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                layoutParams?.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            } else {
                layoutParams?.type = TYPE_SYSTEM_ERROR
            }

            layoutParams?.dimAmount = 0.0f // transparent
            layoutParams?.width = ViewGroup.LayoutParams.MATCH_PARENT
            layoutParams?.height = 0
            layoutParams?.gravity = Gravity.BOTTOM
            layoutParams?.flags = FLAG_NOT_TOUCH_MODAL
            window?.attributes = layoutParams
            setCancelable(false)
        }

        override fun dispatchTouchEvent(motionevent: MotionEvent): Boolean {
            // The event will then be handled by the view group.
            return false
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val viewOverlay = FrameLayout(context)
            viewOverlay.setBackgroundColor(Color.TRANSPARENT)
            setContentView(viewOverlay)
        }
    }
}
