package com.khavronsky.myapplication333.questionnaire;


import java.util.List;

public class QuestionsModel {
    private int imgResource;
    private String title;
    private String question;
    private boolean multiChoice;
    private List<Answer> answers;

    public static class Answer {
        private String answer;
        private boolean selected;

        public String getAnswer() {
            return answer;
        }

        public Answer setAnswer(String answer) {
            this.answer = answer;
            return this;
        }

        public boolean isSelected() {
            return selected;
        }

        public Answer setSelected(boolean selected) {
            this.selected = selected;
            return this;
        }
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isMultiChoice() {
        return multiChoice;
    }

    public void setMultiChoice(boolean multiChoice) {
        this.multiChoice = multiChoice;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
