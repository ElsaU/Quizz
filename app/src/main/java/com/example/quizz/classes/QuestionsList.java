package com.example.quizz.classes;

import java.util.ArrayList;
import java.util.List;

public class QuestionsList {

    public static List<Question> getQuestionsList(){

        final List<Question> questionList = new ArrayList<>();

        //final Question question = new Question("","","","","","");
        final Question question1 = new Question("¿Cuál es el apellido de Jane de 'Tarzán'?","Porter","Thompson","Carter","Watson","Porter");
        final Question question2 = new Question("¿Qué princesa Disney habla menos?", "Jasmín", "Aurora", "Blancanieves", "Cenicienta", "Aurora");
        final Question question3 = new Question("¿En qué país ocurre 'Pinocho'?","Francia","Suiza","Italia","Alemania","Italia");
        final Question question4 = new Question("Uno de estos nombres no corresponde a una hermana de Ariel. ¿Cuál es?","Adrinna","Aquata","Arista","Atella","Atella");
        final Question question5 = new Question("¿Qué nombre usa Úrsula en 'La Sirenita' al convertirse en una hermosa joven?","Elisa","Clarissa","Vanessa","Adriana","Vanessa");
        final Question question6 = new Question("La frase 'Ser valiente no quiere decir que debas buscar problemas.' pertenece a la película...","Buscando a Nemo","Brave","Mulán","El Rey León","El Rey León");
        final Question question7 = new Question("¿Cómo se llama el mejor amigo de Aladdin?","Scar","Rajah","Abú","Jafar","Abú");
        final Question question8 = new Question("¿Quién es Sebastián?","Un cangrejo","Un pez","Un príncipe","Un tiburón","Un cangrejo");
        final Question question9 = new Question("¿Dónde vive Peter Pan?","En Londres","En el Big Ben","En la Estrella Polar","En el País de Nunca Jamás","En el País de Nunca Jamás");
        final Question question10 = new Question("¿Qué mano le falta al capitán Garfio?","La derecha","La izquierda","Las dos","Ninguna","La izquierda");
        final Question question11 = new Question("¿Cuál es el nombre de los siete enanitos de Blancanieves?","Sabiondo, Gruñón, Estornudos, Tímido, Mudito, Dormilón y Bonachón","Sabiondo, Enfadón, Estornudos, Tímido, Mudito, Dormilón y Bonachón","Sabiondo, Gruñón, Estornudos, Tímido, Mudito, Dormilón y Buenazo","Listillo, Gruñón, Estornudos, Vergonzosillo, Mudito, Dormilón y Bonachón","Sabiondo, Gruñón, Estornudos, Tímido, Mudito, Dormilón y Bonachón");
        final Question question12 = new Question("¿Cuál es el lema de Timón y Pumba?","Hakumba matata, vive y deja vivir","Hakuna matata, vive y sé feliz","Hakuna patata, vive y sé feliz","Hakuna batata, vive y deja vivir","Hakuna matata, vive y sé feliz");
        final Question question13 = new Question("¿En qué convirtió el Hada Madrina de Cenicienta a los ratones?","En lacayos","En caballos","En carroza","En cocheros","En caballos");
        final Question question14 = new Question("¿Por qué acude Bella al castillo de Bestia?","Va a buscar comida para su hermana","Quiere resguardarse de la lluvia","Va a rescatar a su padre","Es Bestia quien la secuestra y se la lleva al castillo","Va a rescatar a su padre");
        final Question question15 = new Question("¿Cómo se llama la malvada bruja de la Bella Durmiente?","Maléfica","Úrsula","Cruella Devil","Madam Mim","Maléfica");

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
        questionList.add(question11);
        questionList.add(question12);
        questionList.add(question13);
        questionList.add(question14);
        questionList.add(question15);

        return questionList;
    }
}
