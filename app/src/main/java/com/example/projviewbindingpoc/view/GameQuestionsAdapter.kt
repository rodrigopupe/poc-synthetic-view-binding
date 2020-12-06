package com.example.projviewbindingpoc.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.projviewbindingpoc.data.models.Question
import com.example.projviewbindingpoc.databinding.StatementItemBinding

class GameQuestionsAdapter : RecyclerView.Adapter<GameQuestionsAdapter.GameQuestionsViewHolder>() {

    private var questions = listOf<Question>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameQuestionsViewHolder {
        val itemBinding = StatementItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameQuestionsViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = questions.size

    override fun onBindViewHolder(holder: GameQuestionsViewHolder, position: Int) {
        holder.bind(questions[position])
    }

    fun updateList(newList: List<Question>) {
        questions = newList
        notifyDataSetChanged()
    }

    class GameQuestionsViewHolder(private val itemBinding: StatementItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: Question) {
            itemBinding.question = item

            itemBinding.rgStatementOptions.setOnCheckedChangeListener { radioGroup, checkedRadioButtonId ->
                val radioButton = radioGroup.findViewById<RadioButton>(checkedRadioButtonId)
                item.userChoiceIndex = radioButton.tag.toString().toInt()
            }

            itemBinding.executePendingBindings()
        }
    }
}