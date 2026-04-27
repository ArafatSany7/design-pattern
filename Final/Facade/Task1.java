// Dorkari sub systemer class sobar shurutei , no interface or obstract
class AuthenticationService{
    public void verifyCredintial(int id){
        System.out.println("Student credintial checking for id "+id);
    }
}

class QuestionServide{
    public void verifyQuestion(String questionSet){
        System.out.println("Question set match for the set " + questionSet);
    }
}

class TimerService{
    public void startTimer(int time){
        System.out.println("Timer started for "+time+" minute");
    }
}

class StudentFacde{
    private AuthenticationService authenticationService;
    private QuestionServide questionServide;
    private TimerService timerService;

    public StudentFacde(){
        this.authenticationService =  new AuthenticationService();
        this.questionServide =  new QuestionServide();
        this.timerService = new TimerService();
    }

    public void  verifyCredintial(int id){
        authenticationService.verifyCredintial(id);
    }
     public void verifyQuestion(String questionSet){
        questionServide.verifyQuestion(questionSet);
    }
}


public class Task1 {
    public static void main(String[] args) {
        StudentFacde studentfacade =  new StudentFacde();

        studentfacade.verifyCredintial(345);
        studentfacade.verifyQuestion("E");
    }
}
