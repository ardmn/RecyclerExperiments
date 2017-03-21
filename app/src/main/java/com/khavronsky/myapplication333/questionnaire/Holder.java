package com.khavronsky.myapplication333.questionnaire;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.khavronsky.myapplication333.R;

class Holder extends RecyclerView.ViewHolder {
    private TextView tv_item;
    private CheckBox checkBox;
    private ICheckListener listener;
    private View answerItem;



    Holder(View view) {
        super(view);

        tv_item = (TextView) view.findViewById(R.id.tv3_item);
        checkBox = (CheckBox) view.findViewById(R.id.my_checkbox);
        answerItem = view.findViewById(R.id.qstn_answer_item);

    }
//todo вот сколько вызывается setOnClickListener и создается ананимный класс ? :)
    //todo listener на всякий случай я бы проверял на null 
    void setAnswer(String text, boolean selected, boolean multiChoosingType) {

        tv_item.setText(text);
        checkBox.setChecked(selected);
        checkBox.setBackgroundResource(setCheckBoxDrawable(multiChoosingType));

        answerItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.check(checkBox.isChecked());
            }
        });
    }

    //todo используй котороткую форму условного оператора типа : return multiChoice?CheckBoxType.CHECK_TYPE.getRes() : ... ;
    private int setCheckBoxDrawable(boolean multiChoice) {
        CheckBoxType drawable;
        if (multiChoice) {
            drawable = CheckBoxType.CHECK_TYPE;
        } else {
            drawable = CheckBoxType.RADIO_TYPE;
        }

        return drawable.getRes();
    }

    //todo вот не нравится мне subscribe это больше в стиле rx так что давай заменим на set
    public void subscribeCheckListener(ICheckListener listener) {
        this.listener = listener;
    }

    interface ICheckListener {
        void check(boolean isChecked);
    }

    //todo enum замени на @IntDef
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
