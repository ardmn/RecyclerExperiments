package com.khavronsky.myapplication333.questionnaire;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.khavronsky.myapplication333.R;


public class DialogFrg extends DialogFragment {

// todo по возможности свойтва класса седалть private
    TextView btn_ok;
    TextView btn_cancel;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Adapter adapter;
    private QuestionsModel question;
    boolean announcement = false;
    IQstDialogListener dialogListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        Dialog dialog = new Dialog(getContext(),R.style.FullScreenActivity);
//        Dialog dialog = super.onCreateDialog(savedInstanceState);
        Dialog dialog = new Dialog(getContext(), android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view;
        
        // todo ветку по true - убрать 
        if (announcement) {
            view = inflater.inflate(R.layout.dialog_frg_announcement, container, false);
            if (question != null) {
                init(view);
            }
            btn_ok = (TextView) view.findViewById(R.id.qstn_btn_ok);
            btn_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });

        } else {
            view = inflater.inflate(R.layout.dialog_frg, container, false);
            //todo зачем это условие ? если все равно вызывается init(view); ???
            if (question != null) {
                init(view);
            }init(view);
            btn_ok = (TextView) view.findViewById(R.id.qstn_btn_ok);
            btn_cancel = (TextView) view.findViewById(R.id.qstn_btn_cancel);

            btn_ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (answerSelected()) {
                        dialogListener.answersSelected(question);
                        dismiss();
                    } else {
                        Toast.makeText(getContext(), "Ни один вариант не выбран", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            btn_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogListener.questionAborted();
                    dismiss();
                }
            });

            recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
            layoutManager = new LinearLayoutManager(getActivity());
            adapter = new Adapter();
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            adapter.setQuestion(question);
            adapter.subscribeToIQDListener(new IQstDialogListener() {
                
                //todo зачем question = answerList; ???
                @Override
                public void answersSelected(QuestionsModel answerList) {
                    question = answerList;
                    Toast.makeText(getContext(), "Checked", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void questionAborted() {
                }
            });
            
             //todo зачем adapter.notifyDataSetChanged();
            adapter.notifyDataSetChanged();
        }
        return view;
    }

    // todo не пойму зачем этот метод если часть кода в нем , часть в другом ...
    private void init(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.qstn_img);
        TextView title = (TextView) view.findViewById(R.id.qstn_title);
        TextView questionText = (TextView) view.findViewById(R.id.qstn_text);

        imageView.setBackgroundResource(question.getImgResource());
        title.setText(question.getTitle());
        questionText.setText(question.getQuestion());
    }
//    @Override
//    public void onStart() {
    // getDialog().getWindow().setWindowAnimations(R.style.MatchActivityDialog);
//        super.onStart();
//        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        getDialog().getWindow().setBackgroundDrawable(null);
//    }

    /**
     * true - информационный диалог без списка ответов, с единственной кнопкой "OK"
     * По умолчанию показывается анонс. Для вставки другого текста надо заполнить:
     * .setTitle - заголовок,  .setImgResource - изображение,  .setQuestion - информационный текст
     * <p>
     * false - диалог с вариантами ответов из QuestionsModel
     */
    public void showAnnouncement(boolean isAnnouncement) {
        announcement = isAnnouncement;
    }
// todo - удалить метод
    public void setQuestion(QuestionsModel question) {
        this.question = question;
    }

    //todo поменять на setListener
    public void subscribeToIQDListener(IQstDialogListener listener) {
        this.dialogListener = listener;
    }

    public interface IQstDialogListener {
        void answersSelected(QuestionsModel answerList);
//todo передавать QuestionsModel
        void questionAborted();
    }

    boolean answerSelected() {
        for (QuestionsModel.Answer answer :
                question.getAnswers()) {
            if (answer.isSelected()) return true;
        }
        return false;
    }
}
