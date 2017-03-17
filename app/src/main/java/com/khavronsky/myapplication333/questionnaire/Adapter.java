package com.khavronsky.myapplication333.questionnaire;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khavronsky.myapplication333.R;

import java.util.ArrayList;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<Holder> {
    private List<String> stringList = new ArrayList<>();
    private QuestionsModel questions;


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_to_rec, parent, false);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) { //TODO надо подумать, что делать с final int position
        holder.setText(stringList.get(position));
        holder.setDrawable(questions.isMultiChoice());
        holder.setAnswer(questions.getAnswers().get(position));
        holder.subscribeCheckListener(new Holder.ICheckListener() {
            @Override
            public void check(boolean isChecked) {
                questions.getAnswers()
                        .get(position)
                        .setSelected(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = stringList.size();
//        int count = 2;
        return count;
    }

    void setStringList(List stringList) {
        this.stringList = stringList;
    }

    void setQuestion(QuestionsModel question) {
        this.questions = question;
    }
}
