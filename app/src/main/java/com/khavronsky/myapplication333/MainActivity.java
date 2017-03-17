package com.khavronsky.myapplication333;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.khavronsky.myapplication333.questionnaire.Adapter;
import com.khavronsky.myapplication333.questionnaire.DialogFrg;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Adapter adapter;
    Button button1;
    Button button2;
    DialogFrg dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.but1);
        button2 = (Button) findViewById(R.id.but_announcement);
        dialog = new DialogFrg();
        dialog.setOldList(createStringList());
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.showAnnouncement(false);
                dialog.show(getSupportFragmentManager(), null);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.showAnnouncement(true);
                dialog.show(getSupportFragmentManager(), null);
            }
        });
    }

    List createStringList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Прибежали в избу дети\n" +
                "Второпях зовут отца:\n" +
                "«Тятя! тятя! наши сети\n" +
                "Притащили мертвеца».");
        stringList.add("«Врите, врите, бесенята,—\n" +
                "Заворчал на них отец; —\n" +
                "Ох, уж эти мне робята!\n" +
                "Будет вам ужо мертвец!");
        stringList.add("Суд наедет, отвечай-ка;\n" +
                "С ним я ввек не разберусь;\n" +
                "Делать нечего; хозяйка,\n" +
                "Дай кафтан: уж поплетусь...");
        stringList.add("Где ж мертвец?» — «Вон, тятя, э-вот!»\n" +
                "В самом деле, при реке,\n" +
                "Где разостлан мокрый невод,\n" +
                "Мертвый виден на песке.");
        stringList.add("Безобразно труп ужасный\n" +
                "Посинел и весь распух.\n" +
                "Горемыка ли несчастный\n" +
                "Погубил свой грешный дух,");
        stringList.add("Рыболов ли взят волнами,\n" +
                "Али хмельный молодец,\n" +
                "Аль ограбленный ворами\n" +
                "Недогадливый купец?");
        stringList.add("Мужику какое дело?\n" +
                "Озираясь, он спешит;\n" +
                "Он потопленное тело\n" +
                "В воду за ноги тащит,");
        stringList.add("И от берега крутого\n" +
                "Оттолкнул его веслом,\n" +
                "И мертвец вниз поплыл снова\n" +
                "За могилой и крестом.");
        stringList.add("Долго мертвый меж волнами\n" +
                "Плыл качаясь, как живой;\n" +
                "Проводив его глазами,\n" +
                "Наш мужик пошел домой.");
        stringList.add("«Вы, щенки! за мной ступайте!\n" +
                "Будет вам по калачу,\n" +
                "Да смотрите ж, не болтайте,\n" +
                "А не то поколочу».");
        stringList.add("В ночь погода зашумела,\n" +
                "Взволновалася река,\n" +
                "Уж лучина догорела\n" +
                "В дымной хате мужика,");
        stringList.add("Дети спят, хозяйка дремлет,\n" +
                "На полатях муж лежит,\n" +
                "Буря воет; вдруг он внемлет:\n" +
                "Кто-то там в окно стучит.");
        stringList.add("«Кто там?» — «Эй, впусти, хозяин!» —\n" +
                "«Ну, какая там беда?\n" +
                "Что ты ночью бродишь, Каин?\n" +
                "Черт занес тебя сюда;");
        stringList.add("Где возиться мне с тобою?\n" +
                "Дома тесно и темно».\n" +
                "И ленивою рукою\n" +
                "Подымает он окно.");
        stringList.add("Из-за туч луна катится —\n" +
                "Что же? голый перед ним:\n" +
                "С бороды вода струится,\n" +
                "Взор открыт и недвижим,");
        stringList.add("Все в нем страшно онемело,\n" +
                "Опустились руки вниз,\n" +
                "И в распухнувшее тело\n" +
                "Раки черные впились.");
        stringList.add("И мужик окно захлопнул:\n" +
                "Гостя голого узнав,\n" +
                "Так и обмер: «Чтоб ты лопнул!»\n" +
                "Прошептал он, задрожав.");
        stringList.add("Страшно мысли в нем мешались,\n" +
                "Трясся ночь он напролет,\n" +
                "И до утра всё стучались\n" +
                "Под окном и у ворот.");
        stringList.add("Есть в народе слух ужасный:\n" +
                "Говорят, что каждый год\n" +
                "С той поры мужик несчастный\n" +
                "В день урочный гостя ждет;");
        stringList.add("Уж с утра погода злится,\n" +
                "Ночью буря настает,\n" +
                "И утопленник стучится\n" +
                "Под окном и у ворот.");
        return stringList;
    }

}
