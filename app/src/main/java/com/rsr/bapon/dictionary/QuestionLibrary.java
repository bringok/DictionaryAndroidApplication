package com.rsr.bapon.dictionary;


public class QuestionLibrary {

    private String mQuestions [] = {
            "What is the Synonym of 'Ethics'?",
            "What is the Antonym of 'Happy'?",
            "What is the Synonym of 'Ancestor'?",
            "What is the Synonym of 'Omnivorous'?",
            "What is the Synonym of 'Travel'?",
            "What is the Synonym of 'Sports'?",
            "What is the Synonym of 'Environment'?",
            "What is the Synonym of 'Family'?",
            "What is the Synonym of 'Profession'?",
            "What is the Antonym of 'Legal'?",
            "What is the Synonym of 'Emotion'?",
            "What is the Synonym of 'Personality'?",
            "What is the Synonym of 'Employment'?",
            "What is the Synonym of 'Academic'?",
            "What is the Synonym of 'Economics'?",
            "What is the Synonym of 'Weather'?",
            "What is the Synonym of 'Harvest'?",
            "What is the Antonym of 'Sacrifice'?",
            "What is the Antonym of 'Victim'?",
            "What is the Antonym of 'Ability'?",
            "What is the Antonym of 'Ability'?"
    };

    private String mChoices [][] = {
            {"Morality","Rank","Freedom"},
            {"Crazy","Honest","Sad"},
            {"Foreigner","Psychics","Generatrix"},
            {"Amphibian","Totalitarian","Vegeterian"},
            {"Tour","Fun","Parergon"},
            {"Vocation","Athletics","Sadness"},
            {"Terrain","Medium","Surroundings"},
            {"Blood","Enemy","Strain"},
            {"Slot","Career","Thing"},
            {"Allowed","Clean","Illicit"},
            {"Apathy","Lethargy","Affection"},
            {"Selfdom","Emotions","makeup"},
            {"Idleness","Fun","Pursuit"},
            {"Ignorent","Scholastic","Simple"},
            {"Bearish","Cut","Business"},
            {"Cope","Tussle","Climate"},
            {"Rise","Source","Autumn"},
            {"Surrender","Endure","Deny"},
            {"Martyr","Criminal","Stooge"},
            {"Skill","Might","Lack"},
            {"Skill","Might","Lack"}
    };

    private String mCorrectAnswers[] = {"Morality","Sad","Generatrix","Totalitarian","Tour","Athletic","Surroundings","Blood","Career","Illicit","Affection","Selfdom","Pursuit","Scholastic","Business","Climate","Autumn","Deny","Criminial","Lack","Lack"};


    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a){
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
