package com.khavronsky.myapplication333.questionnaire;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khavronsky.myapplication333.R;


public class Adapter extends RecyclerView.Adapter<Holder> {
    private QuestionsModel question;
    private DialogFrg.IQstDialogListener listener;


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_to_rec, parent, false);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        holder.setAnswer(question.getAnswers().get(position).getAnswer(), question.getAnswers().get(position).isSelected(), question.isMultiChoice());

        holder.subscribeCheckListener(new Holder.ICheckListener() {
            @Override
            public void check(boolean isChecked) {
                Log.d("123", "check input -> isChecked: " + isChecked);
                if (!question.isMultiChoice()) {
                    question.getAnswers()
                            .get(holder.getAdapterPosition())
                            .setSelected(true);
                    for (int i = 0; i < question.getAnswers().size(); i++) {
                        if (i != holder.getAdapterPosition()) {

                            question.getAnswers()
                                    .get(i)
                                    .setSelected(false);

                        }
                    }
                } else {
                    isChecked = !isChecked;
                    question.getAnswers()
                            .get(holder.getAdapterPosition())
                            .setSelected(isChecked);
                    Log.d("123", "isChecked: " + isChecked);
                }
                listener.answersSelected(question);
            }
        });
    }

    @Override
    public int getItemCount() {
        return question != null ? question.getAnswers().size() : 0;
    }

    void subscribeToIQDListener(DialogFrg.IQstDialogListener listener) {
        this.listener = listener;
    }


    void setQuestion(QuestionsModel question) {
        this.question = question;
    }
}
