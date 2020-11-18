package secretymus.id.notes.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_add_button.view.*
import secretymus.id.notes.R
import secretymus.id.notes.foundations.BaseRecyclerAdapter
import secretymus.id.notes.models.Note
import secretymus.id.notes.navigation.NavigationActivity
import secretymus.id.notes.task.TaskAdapter
import secretymus.id.notes.views.NoteView

class NoteAdapter (
    noteList: MutableList<Note> = mutableListOf(),
    val touchActionDelegate: NoteListFragment.TouchActionDelegate
) : BaseRecyclerAdapter<Note>(noteList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = if (viewType == TYPE_ADD_BUTTON) {
        AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
    } else {
        NoteViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )
    }

    class NoteViewHolder(view: View): BaseViewHolder<Note>(view){
        override fun onBind(data: Note) {
            (view as NoteView).initView(data)
        }
    }

    inner class AddButtonViewHolder (view: View) : BaseRecyclerAdapter.AddButtonViewHolder(view) {
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_note)

            view.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_NOTE)
            }
        }
    }

}