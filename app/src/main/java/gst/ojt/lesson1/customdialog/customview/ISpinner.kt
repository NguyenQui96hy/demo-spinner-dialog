package gst.ojt.lesson1.customdialog.customview

interface ISpinner {
    fun closeSpinner()
    fun openSpinner()
    fun setAdapter(dataAdapter: DataAdapter)
    fun disableSpinner(isDisable: Boolean)
}