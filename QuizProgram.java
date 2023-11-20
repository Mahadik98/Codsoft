import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctAnswer;

    public QuizQuestion(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class QuizProgram {
    private static Scanner scanner = new Scanner(System.in);
    private static List<QuizQuestion> questions = new ArrayList<>();
    private static int score = 0;

    public static void main(String[] args) {
        // Create quiz questions
        createQuizQuestions();

        // Display questions and get user answers
        displayQuestions();

        // Display result
        displayResult();
    }

    private static void createQuizQuestions() {
        // Add quiz questions with options and correct answers
        QuizQuestion question1 = new QuizQuestion("What is the capital of France?",
                Arrays.asList("A. London", "B. Paris", "C. Rome", "D. Madrid"), 1);
        QuizQuestion question2 = new QuizQuestion("Which planet is known as the Red Planet?",
                Arrays.asList("A. Jupiter", "B. Venus", "C. Mars", "D. Saturn"), 2);
        QuizQuestion question3 = new QuizQuestion("What is the largest mammal?",
                Arrays.asList("A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Hippopotamus"), 1);
        // Add more questions as needed...

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        // Add more questions as needed...
    }

    private static void displayQuestions() {
        System.out.println("Welcome to the Quiz!");
        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion currentQuestion = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + currentQuestion.getQuestion());
            List<String> options = currentQuestion.getOptions();
            for (String option : options) {
                System.out.println(option);
            }
            System.out.print("Enter your answer: ");
            String userAnswer = scanner.nextLine().toUpperCase();

            int correctAnswerIndex = currentQuestion.getCorrectAnswer() - 1;
            String correctAnswer = currentQuestion.getOptions().get(correctAnswerIndex).substring(0, 1);

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is " + correctAnswer);
            }
        }
    }

    private static void displayResult() {
        System.out.println("\nQuiz ended! Here is your result:");
        System.out.println("Total score: " + score + "/" + questions.size());

        // Display correct/incorrect answers
        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion currentQuestion = questions.get(i);
            int correctAnswerIndex = currentQuestion.getCorrectAnswer() - 1;
            String correctAnswer = currentQuestion.getOptions().get(correctAnswerIndex).substring(0, 1);

            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestion());
            System.out.println("Your answer: "
                    + (scanner.nextLine().toUpperCase().equals(correctAnswer) ? "Correct" : "Incorrect"));
        }
    }
}