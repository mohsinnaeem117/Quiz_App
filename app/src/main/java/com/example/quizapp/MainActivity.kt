package com.example.quizapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var quizModelList: MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        quizModelList = mutableListOf()
        getDataFromFirebase()

    }

    private fun setupRecyclerView() {
        adapter = QuizListAdapter(quizModelList)
        binding.RV.layoutManager = LinearLayoutManager(this)
        binding.RV.adapter = adapter
    }

    private fun getDataFromFirebase() {
        //dummy data
        val programmingQuestions = mutableListOf<QuestionModel>()
        programmingQuestions.add(
            QuestionModel(
                "What is Android?",
                mutableListOf("Language", "OS", "Product", "None"),
                "OS"
            )
        )
        programmingQuestions.add(
            QuestionModel(
                "Who owns Android?",
                mutableListOf("Apple", "Google", "Samsung", "Microsoft"),
                "Google"
            )
        )
        programmingQuestions.add(
            QuestionModel(
                "Which assistant does Android use?",
                mutableListOf("Siri", "Cortana", "Google Assistant", "Alexa"),
                "Google Assistant"
            )
        )
        programmingQuestions.add(
            QuestionModel(
                "What is the base language for Android development?",
                mutableListOf("Java", "Kotlin", "C++", "Python"),
                "Java"
            )
        )
        programmingQuestions.add(
            QuestionModel(
                "Which layout is used to arrange elements linearly?",
                mutableListOf("RelativeLayout", "LinearLayout", "ConstraintLayout", "FrameLayout"),
                "LinearLayout"
            )
        )
        programmingQuestions.add(
            QuestionModel(
                "What is the primary IDE for Android development?",
                mutableListOf("Eclipse", "IntelliJ IDEA", "NetBeans", "Android Studio"),
                "Android Studio"
            )
        )
        programmingQuestions.add(
            QuestionModel(
                "Which component is used for background tasks?",
                mutableListOf("Service", "Activity", "BroadcastReceiver", "ContentProvider"),
                "Service"
            )
        )
        programmingQuestions.add(
            QuestionModel(
                "What is an APK?",
                mutableListOf(
                    "Android Package",
                    "Android Kit",
                    "Application Package",
                    "Application Kit"
                ),
                "Android Package"
            )
        )
        programmingQuestions.add(
            QuestionModel(
                "Which file specifies the layout of an Android app?",
                mutableListOf(
                    "MainActivity.kt",
                    "activity_main.xml",
                    "AndroidManifest.xml",
                    "strings.xml"
                ),
                "activity_main.xml"
            )
        )
        programmingQuestions.add(
            QuestionModel(
                "What does ADB stand for?",
                mutableListOf(
                    "Android Debug Bridge",
                    "Application Debug Bridge",
                    "Android Development Bridge",
                    "Application Development Bridge"
                ),
                "Android Debug Bridge"
            )
        )

        val computerQuestions = mutableListOf<QuestionModel>()
        computerQuestions.add(
            QuestionModel(
                "What does CPU stand for?",
                mutableListOf(
                    "Central Processing Unit",
                    "Central Programming Unit",
                    "Central Power Unit",
                    "Central Performance Unit"
                ),
                "Central Processing Unit"
            )
        )
        computerQuestions.add(
            QuestionModel(
                "What is the brain of the computer?",
                mutableListOf("RAM", "Hard Disk", "CPU", "GPU"),
                "CPU"
            )
        )
        computerQuestions.add(
            QuestionModel(
                "What does RAM stand for?",
                mutableListOf(
                    "Random Access Memory",
                    "Read Access Memory",
                    "Rapid Access Memory",
                    "Random Active Memory"
                ),
                "Random Access Memory"
            )
        )
        computerQuestions.add(
            QuestionModel(
                "Which of the following is an input device?",
                mutableListOf("Monitor", "Keyboard", "Printer", "Speaker"),
                "Keyboard"
            )
        )
        computerQuestions.add(
            QuestionModel(
                "What is the primary function of an operating system?",
                mutableListOf(
                    "To manage computer resources",
                    "To play games",
                    "To edit documents",
                    "To browse the internet"
                ),
                "To manage computer resources"
            )
        )
        computerQuestions.add(
            QuestionModel(
                "Which part of the computer stores the operating system?",
                mutableListOf("RAM", "CPU", "Hard Disk", "Motherboard"),
                "Hard Disk"
            )
        )
        computerQuestions.add(
            QuestionModel(
                "What does GPU stand for?",
                mutableListOf(
                    "Graphics Processing Unit",
                    "General Processing Unit",
                    "Graphical Performance Unit",
                    "Graphics Power Unit"
                ),
                "Graphics Processing Unit"
            )
        )
        computerQuestions.add(
            QuestionModel(
                "Which of the following is a storage device?",
                mutableListOf("Monitor", "Keyboard", "Hard Disk", "CPU"),
                "Hard Disk"
            )
        )
        computerQuestions.add(
            QuestionModel(
                "What does BIOS stand for?",
                mutableListOf(
                    "Basic Input Output System",
                    "Basic Integrated Operating System",
                    "Binary Input Output System",
                    "Basic Interactive Operating System"
                ),
                "Basic Input Output System"
            )
        )
        computerQuestions.add(
            QuestionModel(
                "Which of the following is a programming language?",
                mutableListOf("HTML", "HTTP", "URL", "FTP"),
                "HTML"
            )
        )

        val geographyQuestions = mutableListOf<QuestionModel>()
        geographyQuestions.add(
            QuestionModel(
                "What is the capital of France?",
                mutableListOf("Berlin", "Madrid", "Paris", "Lisbon"),
                "Paris"
            )
        )
        geographyQuestions.add(
            QuestionModel(
                "Which is the largest continent?",
                mutableListOf("Africa", "Asia", "Europe", "Australia"),
                "Asia"
            )
        )
        geographyQuestions.add(
            QuestionModel(
                "What is the longest river in the world?",
                mutableListOf("Amazon", "Nile", "Yangtze", "Mississippi"),
                "Nile"
            )
        )
        geographyQuestions.add(
            QuestionModel(
                "Which is the smallest country by land area?",
                mutableListOf("Vatican City", "Monaco", "San Marino", "Liechtenstein"),
                "Vatican City"
            )
        )
        geographyQuestions.add(
            QuestionModel(
                "What is the highest mountain in the world?",
                mutableListOf("K2", "Kangchenjunga", "Lhotse", "Mount Everest"),
                "Mount Everest"
            )
        )
        geographyQuestions.add(
            QuestionModel(
                "Which ocean is the largest?",
                mutableListOf("Atlantic", "Indian", "Arctic", "Pacific"),
                "Pacific"
            )
        )
        geographyQuestions.add(
            QuestionModel(
                "What is the capital of Japan?",
                mutableListOf("Beijing", "Seoul", "Tokyo", "Bangkok"),
                "Tokyo"
            )
        )
        geographyQuestions.add(
            QuestionModel(
                "Which country has the most population?",
                mutableListOf("India", "USA", "China", "Russia"),
                "China"
            )
        )
        geographyQuestions.add(
            QuestionModel(
                "What is the largest desert in the world?",
                mutableListOf("Sahara", "Gobi", "Kalahari", "Arabian"),
                "Sahara"
            )
        )
        geographyQuestions.add(
            QuestionModel(
                "What is the longest mountain range in the world?",
                mutableListOf("Rocky Mountains", "Andes", "Himalayas", "Alps"),
                "Andes"
            )
        )

        quizModelList.add(
            QuizModel(
                "1",
                "Programming",
                "All the basic programming",
                "10",
                programmingQuestions
            )
        )
        quizModelList.add(
            QuizModel(
                "2",
                "Computer",
                "All the computer questions",
                "20",
                computerQuestions
            )
        )
        quizModelList.add(
            QuizModel(
                "3",
                "Geography",
                "Boost your geography knowledge",
                "15",
                geographyQuestions
            )
        )


        /* FirebaseDatabase.getInstance().reference
             .get()
             .addOnSuccessListener { dataSnapshot ->
                 if (dataSnapshot.exists()) {
                     for (snapshot in dataSnapshot.children) {
                         val quizModel = snapshot.getValue(QuizModel::class.java)
                         if (quizModel != null) {
                             quizModelList.add(quizModel)
                         }
                     }
                 }
                 setupRecyclerView()
             }*/

        setupRecyclerView()
    }

}