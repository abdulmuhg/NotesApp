package secretymus.id.notes.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_add_button.view.*
import secretymus.id.notes.R
import secretymus.id.notes.foundations.BaseRecyclerAdapter
import secretymus.id.notes.models.Task
import secretymus.id.notes.navigation.NavigationActivity
import secretymus.id.notes.views.TaskView
class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf(),
    val touchActionDelegate: TaskListFragment.TouchActionDelegate
): BaseRecyclerAdapter<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = if (viewType == TYPE_INFO) {
        TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    } else {
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
    }

    class TaskViewHolder(view: View): BaseViewHolder<Task>(view) {

        override fun onBind(data: Task) {
            (view as TaskView).initView(data)
        }
    }

    inner class AddButtonViewHolder(view: View): BaseRecyclerAdapter.AddButtonViewHolder(view) {
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getText(R.string.add_new_task)

            view.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_TASK)
            }
        }
    }
}
