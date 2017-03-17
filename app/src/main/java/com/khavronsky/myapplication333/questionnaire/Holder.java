package com.khavronsky.myapplication333.questionnaire;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.khavronsky.myapplication333.R;


class Holder extends RecyclerView.ViewHolder {
    private TextView tv_item;
    private CheckBox checkBox;
    private QuestionsModel.Answer answer;
    private String text = "";
    private ICheckListener listener;
    private CheckBoxType drawable;


    Holder(View view) {
        super(view);
        tv_item = (TextView) view.findViewById(R.id.tv3_item);
        checkBox = (CheckBox) view.findViewById(R.id.checkbox);
        tv_item.setText(answer.getAnswer());
        checkBox.setButtonDrawable(drawable.getRes());
        checkBox.setChecked(answer.isSelected());
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox.toggle();
                listener.check(checkBox.isSelected());
            }
        });
        tv_item.setText(text);
    }

    void setAnswer(QuestionsModel.Answer answer) {
        this.answer = answer;
    }

    void setDrawable(boolean multiChoice) {
        if (multiChoice){
            drawable =  CheckBoxType.CHECK_TYPE;
        } else {
            drawable = CheckBoxType.RADIO_TYPE;
        }
    }

    void setText(String text) {
        this.text = text;
        tv_item.setText(text);
    }

    public void subscribeCheckListener(ICheckListener listener) {
        this.listener = listener;
    }

    interface ICheckListener {
        void check(boolean isChecked);
    }

    private enum CheckBoxType {
        RADIO_TYPE(R.drawable.radiobutton_selection),
        CHECK_TYPE(R.drawable.checkbox_selection);

        private int res;

        CheckBoxType(int res) {
            this.res = res;
        }

        public int getRes() {
            return res;
        }
    }
}
