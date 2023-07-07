package com.example.quizzcds.classes;

import java.util.ArrayList;
import java.util.List;

public class QuestionsList {

    public static List<Question> getQuestionsList(){

        final List<Question> questionList = new ArrayList<>();

        //final Question question = new Question("","","","","","");
        final Question question1 = new Question("¿Quién no se 'perdió' en Pompeya?","Manu","Hueros","Fran","Ninguno","Hueros");
        final Question question2 = new Question("¿Qúe es 'El Cluclunario'?", "Un planeta", "Un idioma", "Un diccionario", "Un lugar", "Un diccionario");
        final Question question3 = new Question("¿En qué año se fue Manu a Kenia?","","","","","");
        final Question question4 = new Question("Nombre completo de Julia","Julia Huihui Lu Zhang Huang Zhu","Julia Lu Zhang Huihui Huang Zhu","Julia Lu Zhang Huang Zhu","Julia Huihui Lu Zhang Huang Zu","Julia Huihui Lu Zhang Huang Zhu");
        final Question question5 = new Question("Nombre de nuestro grupo musical","Amecucos","Amekokos","Lamekokos","Lamecucos","Amekokos");
        final Question question6 = new Question("¿Quiénes son las bellas durmientes de los viajes?","Julia y Estela","Julia y Elsa","Abril y Julia","Abril y Estela","Abril y Julia");
        //final Question question7 = new Question("","","","","","");

        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);

        return questionList;
    }
}
