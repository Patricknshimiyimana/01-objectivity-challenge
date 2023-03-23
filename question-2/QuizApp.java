import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("In which year did Rwanda host CHOGM?", "A. 2012", "B. 2018", "C. 2022", "C"));
        questions.add(new Question("Where will the football veterans world cup(VCWC2024) take place?", "A. Rwanda",
                "B. Brazil", "C. France", "A"));
        questions.add(new Question("In which year did Rwanda become a member of the Commonwealth?", "A. 2000",
                "B. 2009", "C. 2012", "B"));

        Collections.shuffle(questions);

        int score = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);

            System.out.println("Q" + (i + 1) + ") " + q.getQuestion());
            System.out.println(q.getOption1());
            System.out.println(q.getOption2());
            System.out.println(q.getOption3());

            System.out.print("Select the correct option (A, B or C): ");
            String answer = scanner.nextLine().toUpperCase();

            while (!answer.equals("A") && !answer.equals("B") && !answer.equals("C")) {
                System.out.print("Invalid option selected. Please select A, B or C: ");
                answer = scanner.nextLine().toUpperCase();
            }

            if (answer.equals(q.getAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer was " + q.getAnswer());
            }
            System.out.println();
        }

        System.out.println("Quiz completed! You scored " + score + "/" + questions.size());

        if (score >= 2) {
            System.out.println("Congratulations! You passed the quiz.");
        } else {
            System.out.println(
                    "Sorry, you failed the quiz. To pass, you must have scored atleast 2 out of " + questions.size()
                            + ". Better luck next time!");
        }

        scanner.close();
    }

    static class Question {
        private String question;
        private String option1;
        private String option2;
        private String option3;
        private String answer;

        public Question(String question, String option1, String option2, String option3, String answer) {
            this.question = question;
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public String getOption1() {
            return option1;
        }

        public String getOption2() {
            return option2;
        }

        public String getOption3() {
            return option3;
        }

        public String getAnswer() {
            return answer;
        }
    }
}