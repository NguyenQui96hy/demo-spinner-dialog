package gst.ojt.lesson1.customdialog.customview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gst.ojt.lesson1.customdialog.R
import kotlinx.android.synthetic.main.fruit_item.view.*

class DataAdapter(
    private val mDataset: Array<String>,
    internal var recyclerViewItemClickListener: RecyclerViewItemClickListener
) : RecyclerView.Adapter<DataAdapter.DataCurrencyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): DataCurrencyViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)

        return DataCurrencyViewHolder(v)

    }

    override fun onBindViewHolder(dataCurrencyViewHolder: DataCurrencyViewHolder, i: Int) {
        dataCurrencyViewHolder.mTextView.text = mDataset[i]


    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

     fun setOnItemSelect(itemClick:RecyclerViewItemClickListener){
        this.recyclerViewItemClickListener = itemClick
    }


    inner class DataCurrencyViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        var mTextView: TextView = v.textView

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            recyclerViewItemClickListener.clickOnItem(mDataset[this.adapterPosition])

        }
    }

    interface RecyclerViewItemClickListener {
        fun clickOnItem(data: String)
    }
}