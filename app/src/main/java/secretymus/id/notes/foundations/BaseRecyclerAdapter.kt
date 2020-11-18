package secretymus.id.notes.foundations

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import secretymus.id.notes.task.TaskAdapter

abstract class BaseRecyclerAdapter<T>(
    protected val masterList: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int  = if (position == 0) {
        TYPE_ADD_BUTTON
    } else {
        TYPE_INFO
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AddButtonViewHolder){
            holder.onBind(Unit)
        } else {
            (holder as BaseViewHolder<T>).onBind(masterList[position - 1])
        }
    }

    override fun getItemCount(): Int = masterList.size + 1

    abstract class BaseViewHolder<E>(val view: View) : RecyclerView.ViewHolder(view){
        abstract fun onBind(data: E)
    }

    abstract class AddButtonViewHolder (view: View) : BaseViewHolder<Unit>(view)

    companion object {
        const val TYPE_INFO = 1
        const val TYPE_ADD_BUTTON = 0
    }
}