package Exercise5;

public class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private String feedbackUsingConcatenation(String part1, String part2, String part3, String part4, String part5) {
        return part1 + " " + part2 + " " + part3 + " " + part4 + " " + part5;
    }

    private StringBuilder feedbackUsingStringBuilder(String part1, String part2, String part3, String part4, String part5) {
        StringBuilder sb = new StringBuilder();
        sb.append(part1).append(" ").append(part2).append(" ").append(part3).append(" ").append(part4).append(" ").append(part5);
        return sb;
    }

    private boolean checkFeedbackLength(String feedback) {
        this.longFeedback = feedback.length() > 500;
        return this.longFeedback;
    }

    private String createReviewID(String feedback) {
        String namePart = (lastName.substring(0, 2) + firstName.substring(0, 2)).toUpperCase();
        String feedbackPart = feedback.substring(0, 3).toLowerCase().replace(" ", "");
        int length = feedback.length();
        long timestamp = System.currentTimeMillis();
        this.reviewID = (namePart + feedbackPart + length + "_" + timestamp).replace(" ", "");
        return this.reviewID;
    }

    public void analyseFeedback(boolean useConcat, String part1, String part2, String part3, String part4, String part5) {
        if (useConcat) {
            this.completeFeedback = feedbackUsingConcatenation(part1, part2, part3, part4, part5);
        } else {
            this.completeFeedback = feedbackUsingStringBuilder(part1, part2, part3, part4, part5).toString();
        }
        checkFeedbackLength(this.completeFeedback);
        createReviewID(this.completeFeedback);
    }

    @Override
    public String toString() {
        return "Customer Name: " + firstName + " " + lastName + "\n" +
               "Email: " + email + "\n" +
               "Complete Feedback: " + completeFeedback + "\n" +
               "Long Feedback: " + longFeedback + "\n" +
               "Review ID: " + reviewID;
    }

    public static void main(String[] args) {
        String part1 = "The e-bike was very responsive.";
        String part2 = "The battery lasted longer than expected.";
        String part3 = "I found the app easy to navigate.";
        String part4 = "The pickup location was convenient.";
        String part5 = "I will definitely use the service again.";

        Feedback feedback = new Feedback("John", "Doe", "john.doe@example.com");
        feedback.analyseFeedback(true, part1, part2, part3, part4, part5);
        System.out.println(feedback);
    }
}