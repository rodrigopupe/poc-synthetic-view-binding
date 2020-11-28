package com.example.projviewbindingpoc.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.projviewbindingpoc.R
import com.example.projviewbindingpoc.data.models.Question
import kotlinx.android.synthetic.main.statement_item.view.*

class GameQuestionsAdapter : RecyclerView.Adapter<GameQuestionsAdapter.GameQuestionsViewHolder>() {

    private var questions = listOf<Question>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameQuestionsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.statement_item, parent, false)
        return GameQuestionsViewHolder(view)
    }

    override fun getItemCount(): Int = questions.size

    override fun onBindViewHolder(holder: GameQuestionsViewHolder, position: Int) {
        holder.bind(questions[position])
    }

    fun updateList(newList: List<Question>) {
        questions = newList
        notifyDataSetChanged()
    }

    class GameQuestionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val questionStatement = itemView.tvStatement
        private val statementOptions = itemView.rgStatementOptions

        fun bind(item: Question) {
            questionStatement.text = item.statement
            item.answerOptions.forEachIndexed { i, label ->
                val radioButton = statementOptions.getChildAt(i) as RadioButton
                radioButton.text = label
                radioButton.tag = i
            }

            statementOptions.setOnCheckedChangeListener { radioGroup, checkedRadioButtonId ->
                val radioButton = radioGroup.findViewById<RadioButton>(checkedRadioButtonId)
                item.userChoiceIndex = radioButton.tag as Int
            }
        }
    }
}