package com.example.quizz.classes;

import java.util.ArrayList;
import java.util.List;

public class QuestionsList {

    public static List<Question> getQuestionsList(){

        final List<Question> questionList = new ArrayList<>();

        //final Question question = new Question("","","","","","");
        final Question question1 = new Question("¿Quién no se 'perdió' en Pompeya?","Manu","Hueros","Fran","Ninguno","Hueros");
        final Question question2 = new Question("¿Qué es 'El Cluclunario'?", "Un planeta", "Un idioma", "Un diccionario", "Un lugar", "Un diccionario");
        final Question question3 = new Question("¿En qué año se fue Manu a Kenia?","2012","2011","2010","Nunca ha estado en Kenia","2012");
        final Question question4 = new Question("Nombre completo de Julia","Julia Huihui Lu Zhang Huang Zhu","Julia Lu Zhang Huihui Huang Zhu","Julia Lu Zhang Huang Zhu","Julia Huihui Lu Zhang Huang Zu","Julia Huihui Lu Zhang Huang Zhu");
        final Question question5 = new Question("Nombre de nuestro grupo musical","Amecucos","Amekokos","Lamekokos","Lamecucos","Amekokos");
        final Question question6 = new Question("¿Quiénes son las bellas durmientes de los viajes?","Julia y Estela","Julia y Elsa","Abril y Julia","Abril y Estela","Abril y Julia");
        final Question question7 = new Question("¿De quién es la canción que suena en el video de 'El Reencuentro' de Manu?","Taylor Swift","Lady Gaga","Miley Cyrus","Katy Perry","Katy Perry");
        final Question question8 = new Question("¿Por qué el grupo se llama 'Chat de Siempre'?","","Se decidió en democracia","Se desconoce el motivo","Hubo una guerra de chats","Hubo una guerra de chats");
        final Question question9 = new Question("El vecino de Elsa es también conocido como...","Marinero","Mayorista","Majestad","Mayordomo","Mayordomo");
        final Question question10 = new Question("¿Cuántos de nosotros tienen hermanos mayores?","4","5","3","6","4");

        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);
        questionList.add(question7);
        questionList.add(question8);
        questionList.add(question9);
        questionList.add(question10);

        return questionList;
    }
}
