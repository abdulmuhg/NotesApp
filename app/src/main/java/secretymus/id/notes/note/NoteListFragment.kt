package secretymus.id.notes.note

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TouchDelegate
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_note_list.*
import secretymus.id.notes.R
import secretymus.id.notes.models.Note
import secretymus.id.notes.models.Task
import secretymus.id.notes.task.TaskAdapter

class NoteListFragment : Fragment() {

    lateinit var touchActionDelegate: TouchActionDelegate

    override fun onAttach(context: Context) {
        super.onAttach(context)

        context?.let {
            if (it is TouchActionDelegate) {
                touchActionDelegate = it
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = NoteAdapter(mutableListOf(
            Note("Note One"),
            Note("Note Two")
        ), touchActionDelegate)
        recyclerView.adapter = adapter
    }

    interface TouchActionDelegate{
        fun onAddButtonClicked(value: String)
    }

    companion object {
        fun newInstance() = NoteListFragment()
    }
}