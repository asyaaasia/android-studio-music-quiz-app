package com.asya.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout panelMain, panelWeeknd, panelAriana, panelQuiz, panelResult;
    private TextView WeekText, ArianaText, QuestionText, resultCorrect, resultWrong;
    private Button optionA, optionB, optionC, optionD;

    private MediaPlayer mediaPlayer = new MediaPlayer();

    private int indexQuiz = 0; // sorulan orunun index
    private int CorrectNumber = 0; // Doğru sayısı
    private boolean isweek = false; // true ise the weeknd soruları gözükecek
    private ArrayList<Question> QuestionsWeek = new ArrayList<>();
    private ArrayList<Question> QuestionsAriana = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panelMain = findViewById(R.id.panelMain);
        panelWeeknd = findViewById(R.id.panelWeeknd);
        panelAriana = findViewById(R.id.panelAriana);
        panelQuiz = findViewById(R.id.panelQuiz);
        panelResult = findViewById(R.id.panelQuizEnd);
        WeekText = findViewById(R.id.weekndptext);
        ArianaText = findViewById(R.id.arianaptext);
        QuestionText = findViewById(R.id.QuizText);
        optionA = findViewById(R.id.QuizA);
        optionB = findViewById(R.id.QuizB);
        optionC = findViewById(R.id.QuizC);
        optionD = findViewById(R.id.QuizD);
        resultCorrect = findViewById(R.id.resultCorrect);
        resultWrong = findViewById(R.id.resultWrong);

        panelWeeknd.setVisibility(View.GONE);
        panelAriana.setVisibility(View.GONE);
        panelQuiz.setVisibility(View.GONE);
        panelResult.setVisibility(View.GONE);

        findViewById(R.id.toListen).setOnClickListener(view -> {
            panelMain.setVisibility(View.GONE);
            panelWeeknd.setVisibility(View.VISIBLE);
        });
        findViewById(R.id.toExam0).setOnClickListener(view -> {
            panelMain.setVisibility(View.GONE);
            panelQuiz.setVisibility(View.VISIBLE);
            indexQuiz = -1;
            CorrectNumber = 0;
            isweek = true;
            sonrakiSoru();
        });
        findViewById(R.id.toExam1).setOnClickListener(view -> {
            panelMain.setVisibility(View.GONE);
            panelQuiz.setVisibility(View.VISIBLE);
            indexQuiz = -1;
            CorrectNumber = 0;
            isweek = false;
            sonrakiSoru();
        });
        findViewById(R.id.resultMainMenu).setOnClickListener(v -> {
            panelResult.setVisibility(View.GONE);
            panelMain.setVisibility(View.VISIBLE);
        });

        MuzikSayfalariButon();
        QuizSayfasiButon();
        SorulariHazirla();
    }

    private void MuzikSayfalariButon()
    {
        findViewById(R.id.weeknext).setOnClickListener(view -> {
            mediaPlayer.stop();
            panelWeeknd.setVisibility(View.GONE);
            panelAriana.setVisibility(View.VISIBLE);
            WeekText.setText("");
        });
        findViewById(R.id.ariananext).setOnClickListener(view -> {
            mediaPlayer.stop();
            panelAriana.setVisibility(View.GONE);
            panelMain.setVisibility(View.VISIBLE);
            ArianaText.setText("");
        });

        findViewById(R.id.weekndp0).setOnClickListener(v -> {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(this, R.raw.the_weeknd_blinding_lights);
            mediaPlayer.start();
            WeekText.setText("'The Weeknd' adlı Kanadalı şarkıcı ve söz yazarı Abel Makkonen Tesfaye'nin 2020 yılında çıkardığı 'After Hours' albümünün öne çıkan şarkılarından biridir. 'Blinding Lights,' dünya çapında büyük bir ticari başarı elde etmiş, Billboard Hot 100 listesinde uzun süre zirvede kalmış ve müzik eleştirmenlerinden olumlu eleştiriler almıştır. Aynı zamanda şarkının özgün ve etkileyici müzik videosu da büyük beğeni toplamıştır.\n");
        });
        findViewById(R.id.weekndp1).setOnClickListener(v -> {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(this, R.raw.the_weeknd_save_your_tears);
            mediaPlayer.start();
            WeekText.setText("The Weeknd'in 2020 çıkışlı 'After Hours' albümünden bir diğer önemli parça olan 'Save Your Tears,' popülerlik kazanan şarkılardan biridir. Şarkı, The Weeknd'in özgün sesini ve deneysel müzik tarzını yansıtan etkileyici bir yapıya sahiptir. 'Save Your Tears,' müzik eleştirmenleri ve dinleyiciler tarafından övgü almış ve çeşitli müzik ödüllerine aday gösterilmiştir.\n");
        });
        findViewById(R.id.weekndp2).setOnClickListener(v -> {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(this, R.raw.the_weeknd_cant_feel_my_face);
            mediaPlayer.start();
            WeekText.setText("2015 yılında yayımlanan 'Beauty Behind the Madness' albümünden çıkan 'Can't Feel My Face,' The Weeknd'in çıkış şarkılarından biridir. Popülerlik kazanan ve ticari başarı elde eden bu şarkı, enerjik melodisi ve dikkat çekici sözleriyle dinleyicilerin ilgisini çekmiştir. 'Can't Feel My Face,' birçok müzik ödülü kazanmış ve The Weeknd'in kariyerinde önemli bir dönemeçtir.\n");
        });

        findViewById(R.id.arianap0).setOnClickListener(v -> {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(this, R.raw.ariana_grande_thank_u_next);
            mediaPlayer.start();
            ArianaText.setText("\": Ariana Grande'nin 2019'da çıkardığı aynı adı taşıyan albümünden çıkan bu şarkı, eski ilişkilerinden elde ettiği öğretileri içerir ve kendi gücünü kutlar.\n");
        });
        findViewById(R.id.arianap1).setOnClickListener(v -> {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(this, R.raw.ariana_grande_no_tears_left_to_cry);
            mediaPlayer.start();
            ArianaText.setText("2018'de yayımlanan bu şarkı, Manchester Arena saldırısının ardından çıkan ilk single'dır. Şarkı, zorlukların üstesinden gelme ve umudu temsil eder.\n");
        });
        findViewById(R.id.arianap2).setOnClickListener(v -> {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(this, R.raw.ariana_grande_god_is_a_woman);
            mediaPlayer.start();
            ArianaText.setText("'Sweetener' albümünden çıkan bu şarkı, cinsellik, güç ve bağımsızlık gibi temalara odaklanır. Grande, şarkıda kadınların gücünü ve etkisini vurgular.\n");
        });
    }

    private void QuizSayfasiButon()
    {
        optionA.setOnClickListener(v -> {
            Question current;
            if (isweek) current = QuestionsWeek.get(indexQuiz);
            else current = QuestionsAriana.get(indexQuiz);

            if (current.Correct == 0) CorrectNumber += 1;
            sonrakiSoru();
        });
        optionB.setOnClickListener(v -> {
            Question current;
            if (isweek) current = QuestionsWeek.get(indexQuiz);
            else current = QuestionsAriana.get(indexQuiz);

            if (current.Correct == 1) CorrectNumber += 1;
            sonrakiSoru();
        });
        optionC.setOnClickListener(v -> {
            Question current;
            if (isweek) current = QuestionsWeek.get(indexQuiz);
            else current = QuestionsAriana.get(indexQuiz);

            if (current.Correct == 2) CorrectNumber += 1;
            sonrakiSoru();
        });
        optionD.setOnClickListener(v -> {
            Question current;
            if (isweek) current = QuestionsWeek.get(indexQuiz);
            else current = QuestionsAriana.get(indexQuiz);

            if (current.Correct == 3) CorrectNumber += 1;
            sonrakiSoru();
        });

    }
    private void sonrakiSoru()
    {
        indexQuiz++;
        if ((isweek && indexQuiz >= QuestionsWeek.size()) || (!isweek && indexQuiz >= QuestionsAriana.size()))
        {
            // index soru sayısına eşit oldu veya daha yüksek sınav bitiyor
            resultCorrect.setText(String.valueOf(CorrectNumber));
            int Wrong;
            if (isweek) Wrong = QuestionsWeek.size() - CorrectNumber;
            else Wrong = QuestionsAriana.size() - CorrectNumber;
            resultWrong.setText(String.valueOf(Wrong));
            panelQuiz.setVisibility(View.GONE);
            panelResult.setVisibility(View.VISIBLE);
        }
        else
        {
            Question next;
            if (isweek) next = QuestionsWeek.get(indexQuiz);
            else next = QuestionsAriana.get(indexQuiz);

            QuestionText.setText(next.Quest);
            optionA.setText(next.Options.get(0));
            optionB.setText(next.Options.get(1));
            optionC.setText(next.Options.get(2));
            optionD.setText(next.Options.get(3));
        }
    }

    private void SorulariHazirla()
    {
        QuestionsWeek.clear();
        QuestionsWeek.add(new Question("The Weeknd'in 2020 çıkışlı albümü \"After Hours\"da yer alan hangi şarkısı, dünya çapında büyük bir hit haline gelmiştir? ", "Blinding Lights ", "Save Your Tears ", "Can't Feel My Face", "Starboy",0));
        QuestionsWeek.add(new Question("'Blinding Lights' şarkısı hangi yıl Billboard Hot 100 listesinde zirveye çıkmıştır?", "2019", "2020", "2021", "2022", 1));
        QuestionsWeek.add(new Question("The Weeknd'in \"Save Your Tears\" şarkısı hangi albümünden çıkmıştır?", "Starboy", "Beauty Behind the Madness", "After Hours", "Kiss Land", 2));
        QuestionsWeek.add(new Question("\"Can't Feel My Face\" şarkısı hangi yıl yayımlanmıştır?", "2013", "2014", "2015", "2016", 2));
        QuestionsWeek.add(new Question("The Weeknd'in gerçek adı nedir?", "Abel Makkonen Tesfaye", "Adam Levine", "Michael Jackson", "Justin Timberlake", 0));
        QuestionsWeek.add(new Question("\"Blinding Lights\" şarkısının müzik videosu hangi şehirde çekilmiştir?", "Los Angeles", "Tokyo", "New York", "Las Vegas", 3));
        QuestionsWeek.add(new Question("The Weeknd, hangi ödül töreninde \"Blinding Lights\" performansıyla büyük beğeni toplamıştır?", "Grammy Awards", "MTV Video Music Awards", "Brit Awards", "Billboard Music Awards", 0));
        QuestionsWeek.add(new Question("The Weeknd'in şarkılarında sıkça kullanılan bir tema nedir? ", "Aşk ve Sevgi", "Gece ve Karanlık", "Doğa ve Deniz", "Politika ve Toplumsal Konular", 1));
        QuestionsWeek.add(new Question("\"After Hours\" albümündeki hangi şarkı, The Weeknd'in karakteristik sesini ve deneysel tarzını yansıtmaktadır?", "Heartless", "Faith", "In the Night", "Escape from LA", 0));
        QuestionsWeek.add(new Question("The Weeknd, \"Save Your Tears\" şarkısının remiksi için hangi ünlü sanatçıyla işbirliği yapmıştır?", "Dua Lipa", "Ariana Grande", "Lady Gaga", "Calvin Harris", 1));

        QuestionsAriana.clear();
        QuestionsAriana.add(new Question("\"Thank U, Next\" albümü hangi yıl yayımlanmıştır?", "2018", "2019", "2020", "2021", 1));
        QuestionsAriana.add(new Question("\"No Tears Left to Cry\" şarkısı hangi olayın ardından yazılmıştır?", "Grammy Ödülleri", "Eski bir ilişkinin bitişi", "Manchester Arena saldırısı", "Film projesinin tamamlanması", 2));
        QuestionsAriana.add(new Question("\"God Is a Woman\" şarkısı hangi albümde yer almaktadır?", "Dangerous Woman", "Sweetener", "Thank U, Next", "Yours Truly", 1));
        QuestionsAriana.add(new Question("\"Thank U, Next\" şarkısının sözleri hangi konuyu işler?", "Aşk", "Güç ve Bağımsızlık", "Eski İlişkilerden Öğrenilenler", "Kaygı ve Zorluk", 2));
        QuestionsAriana.add(new Question("\"God Is a Woman\" şarkısının müzik videosu hangi sanatsal eserden esinlenmiştir?", "The Starry Night", "Mona Lisa", "The Birth of Venus", "The Creation of Adam", 3));
        QuestionsAriana.add(new Question("\"No Tears Left to Cry\" şarkısının video klibinde hangi renk tonu ağırlıklı olarak kullanılmıştır?", "Mavi", "Pembe", "Gri", "Sarı", 2));
        QuestionsAriana.add(new Question("\"Thank U, Next\" şarkısının sözlerinde Ariana Grande, eski sevgilileri için hangi duyguyu ifade eder?", "Kin ve Nefret", "Minnettarlık ve Teşekkür", "Aşk ve Tutku", "Hüzün ve Melankoli", 1));
        QuestionsAriana.add(new Question("\"God Is a Woman\" şarkısı hangi müzik tarzını temsil eder?", "Rock", "R&B", "Pop", "Pop/R&B", 3));
        QuestionsAriana.add(new Question("\"No Tears Left to Cry\" şarkısının yapımcısı kimdir?", "Max Martin", "Pharrell Williams", "Ilya Salmanzadeh", "Benny Blanco", 2));
        QuestionsAriana.add(new Question("\"God Is a Woman\" şarkısının video klibinde Ariana Grande, hangi mitolojik figürü canlandırır?", "Medusa", "Persephone", "Athena", "Venüs", 0));
    }

    private class Question
    {
        public String Quest;
        public ArrayList<String> Options;
        public int Correct;

        public Question(String Quest, String oA, String oB, String oC, String oD, int in)
        {
            this.Quest = Quest;
            this.Options = new ArrayList<>();
            Options.add(oA);
            Options.add(oB);
            Options.add(oC);
            Options.add(oD);
            this.Correct = in;
        }
    }
}