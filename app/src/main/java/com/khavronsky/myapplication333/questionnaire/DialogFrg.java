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

import com.khavronsky.myapplication333.R;

import java.util.ArrayList;
import java.util.List;


public class DialogFrg extends DialogFragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Adapter adapter;
    private QuestionsModel question;
    private List<String> oldList = new ArrayList<>();
    boolean announcement = false;
    IQstDialogListener listener;

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
        if (announcement) {

            view = inflater.inflate(R.layout.dialog_frg_announcement, container, false);

        } else {
            view = inflater.inflate(R.layout.dialog_frg, container, false);

            recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
            layoutManager = new LinearLayoutManager(getActivity());
            adapter = new Adapter();
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            adapter.setQuestion(question);
            adapter.setStringList(oldList);
            adapter.notifyDataSetChanged();
        }
        return view;
    }
//    @Override
//    public void onStart() {
    // getDialog().getWindow().setWindowAnimations(R.style.MatchActivityDialog);
//        super.onStart();
//        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        getDialog().getWindow().setBackgroundDrawable(null);
//    }


    public void showAnnouncement(boolean isAnnouncement) {
        announcement = isAnnouncement;
    }

    public void setQuestion(QuestionsModel question) {
        this.question = question;
    }

    public void setOldList(List<String> oldList) {
        this.oldList = oldList;
    }

    public void subscribeToIQDListener(IQstDialogListener listener){
        this.listener = listener;
    }

    public interface IQstDialogListener {
        void answersSelected(QuestionsModel answerList);
    }
}
