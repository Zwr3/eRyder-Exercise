package Exercise5;

class Feedback {
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
        String result = part1 + " " + part2 + " " + part3 + " " + part4 + " " + part5;
        return result;
    }

    private StringBuilder feedbackUsingStringBuilder(String part1, String part2, String part3, String part4, String part5) {
        StringBuilder sb = new StringBuilder();
        sb.append(part1);
        sb.append(" ");
        sb.append(part2);
        sb.append(" ");
        sb.append(part3);
        sb.append(" ");
        sb.append(part4);
        sb.append(" ");
        sb.append(part5);
        return sb;
    }

    private boolean checkFeedbackLength(String feedback) {
        if (feedback.length() > 500) {
            longFeedback = true;
        } else {
            longFeedback = false;
        }
        return longFeedback;
    }

    private String createReviewID(String feedback) {
        String lastTwoOfLastName = lastName.substring(0, 2);
        String lastTwoOfFirstName = firstName.substring(0, 2);
        String namePart = lastTwoOfLastName + lastTwoOfFirstName;
        namePart = namePart.toUpperCase();

        String firstThreeOfFeedback = feedback.substring(0, 3);
        firstThreeOfFeedback = firstThreeOfFeedback.toLowerCase();
        firstThreeOfFeedback = firstThreeOfFeedback.replace(" ", "");

        int feedbackLength = feedback.length();
        long timeNow = System.currentTimeMillis();

        String id = namePart + firstThreeOfFeedback + feedbackLength + "_" + timeNow;
        id = id.replace(" ", "");
        reviewID = id;
        return reviewID;
    }

    public void analyseFeedback(boolean useConcat, String part1, String part2, String part3, String part4, String part5) {
        if (useConcat) {
            completeFeedback = feedbackUsingConcatenation(part1, part2, part3, part4, part5);
        } else {
            StringBuilder sb = feedbackUsingStringBuilder(part1, part2, part3, part4, part5);
            completeFeedback = sb.toString();
        }
        checkFeedbackLength(completeFeedback);
        createReviewID(completeFeedback);
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
        String feedbackPart1 = "The e-bike I rented was really smooth to ride.";
        String feedbackPart2 = "The brakes worked well even when I went fast.";
        String feedbackPart3 = "The app showed me exactly where the bike was parked.";
        String feedbackPart4 = "I had no trouble unlocking it with my phone.";
        String feedbackPart5 = "I will use this service again for sure.";

        String myFirstName = "John";
        String myLastName = "Doe";
        String myEmail = "john.doe@student.com";

        Feedback myFeedback = new Feedback(myFirstName, myLastName, myEmail);

        boolean useStringConcat = true;
        myFeedback.analyseFeedback(useStringConcat, feedbackPart1, feedbackPart2, feedbackPart3, feedbackPart4, feedbackPart5);

        System.out.println("===== Feedback Information =====");
        System.out.println(myFeedback);
        System.out.println("==============================");
    }
}